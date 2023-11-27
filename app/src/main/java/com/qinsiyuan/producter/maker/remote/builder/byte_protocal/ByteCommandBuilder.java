package com.qinsiyuan.producter.maker.remote.builder.byte_protocal;

import android.util.Log;

import com.qinsiyuan.producter.maker.remote.builder.byte_protocal.byte_array_getter.ByteArrayGetter;
import com.qinsiyuan.producter.maker.remote.builder.byte_protocal.byte_array_getter.Liquid;
import com.qinsiyuan.producter.utils.SetableTranslateBuffer;


public class ByteCommandBuilder extends ByteProtocolBuilder{
    public static final String TAG = "ByteCommandBuilder";

    private static final ByteCommandBuilder[] manager = new ByteCommandBuilder[256];

    public static ByteCommandBuilder get(byte cmd){
        if(manager[cmd & 0xff] == null)
            manager[cmd & 0xff] = new ByteCommandBuilder(cmd, new SetableTranslateBuffer());
        return manager[cmd & 0xff];
    }
    private final byte cmd;

    private ByteCommandBuilder(byte cmd, SetableTranslateBuffer buffer) {
        super(buffer);
        this.cmd = cmd;
    }

    public void getByteArray(ByteArrayGetter getter, byte[] buffer) {
        if(buffer == null){
            Log.e(TAG, "buffer is null");
            return;
        }
        if(getter == null){
            Log.e(TAG, "byte array getter is null");
            return;
        }
        buffer[0] = cmd;
        getter.setToByteArray(buffer,1);
    }
}
