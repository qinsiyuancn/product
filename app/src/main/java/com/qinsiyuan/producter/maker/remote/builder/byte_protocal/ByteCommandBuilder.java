package com.qinsiyuan.producter.maker.remote.builder.byte_protocal;

import android.util.Log;

import com.qinsiyuan.producter.maker.remote.builder.byte_protocal.byte_array_getter.ByteArrayGetter;
import com.qinsiyuan.producter.utils.TranslateBuffer;


public class ByteCommandBuilder extends ByteProtocolBuilder{
    public static final String TAG = "ByteCommandBuilder";

    private final byte cmd;

    public ByteCommandBuilder(byte cmd, GetterReporter reporter, TranslateBuffer buffer) {
        super(buffer, reporter);
        this.cmd = cmd;
    }

    @Override
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
