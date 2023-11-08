package com.qinsiyuan.producter.creater;

import android.util.Log;

import com.qinsiyuan.producter.Product;
import com.qinsiyuan.producter.maker.Maker;
import com.qinsiyuan.producter.maker.remote.RemoteMaker;
import com.qinsiyuan.producter.maker.remote.builder.byte_protocal.ByteCommandBuilder;
import com.qinsiyuan.producter.maker.remote.builder.byte_protocal.ByteProtocolBuilder;
import com.qinsiyuan.producter.maker.remote.builder.byte_protocal.GetterReporter;
import com.qinsiyuan.producter.maker.remote.builder.byte_protocal.byte_array_getter.ByteArrayGetter;
import com.qinsiyuan.producter.maker.remote.server.Server;
import com.qinsiyuan.producter.maker.remote.server.request.BufferRequest;
import com.qinsiyuan.producter.utils.FinalTranslateBuffer;
import com.qinsiyuan.producter.utils.TranslateBuffer;

import java.io.IOException;

public class BufferStreamCreater implements ProductCreater, GetterReporter {

    public static final String TAG = "BufferStreamCreater";

    private final ByteArrayGetter getter;
    private final byte order;
    private final String makerName;
    private final String serverName;
    private int param;

    public BufferStreamCreater(ByteArrayGetter getter, byte order, String makerName, String serverName) {
        this.getter = getter;
        this.order = order;
        this.makerName = makerName;
        this.serverName = serverName;
    }

    @Override
    public Product create(String name, String content) {
//        JSONObject json = new JSONObject(jsonString);
        Maker maker = Maker.makerManager.get(makerName);
        if(maker == null) {
            ByteProtocolBuilder builder = ByteProtocolBuilder.manager[order];
            if (builder == null) {
                TranslateBuffer requestBuffer = new FinalTranslateBuffer(getter.cost());
                builder = new ByteCommandBuilder(order, this, requestBuffer);
                ByteProtocolBuilder.manager[order] = builder;
            }
            Server server = Server.manager.get(serverName);
            if(server == null){
                Log.e(TAG, "Server is null, server name: " + serverName);
                return null;
            }

            maker = new RemoteMaker(makerName, builder,
                    new BufferRequest(builder.getBuffer(),server.getOutputStream()));
            Maker.makerManager.put(makerName, maker);
        }
        maker.update();
        return new Product(name, content, maker, param);
    }

    @Override
    public ByteArrayGetter reportGetter(int param) {
        this.param = param;
        return getter;
    }
}
