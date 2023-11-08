package com.qinsiyuan.producter.maker.remote.builder.byte_protocal.byte_array_getter;

import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Int2ByteArrayGetter implements ByteArrayGetter{
    public static final String TAG = "Int2ByteArrayGetter";
    private final int[] param;

    public Int2ByteArrayGetter(int[] param) {
        this.param = param;
    }

    @Override
    public int cost() {
        return param.length * Integer.BYTES;
    }

    @Override
    public void setToByteArray(byte[] array, int startIndex) {
        if(array.length < cost())
            for (int i = 0; i < param.length; i++)
                ByteBuffer.wrap(array, startIndex + i * Integer.BYTES, Integer.BYTES)
                        .order(ByteOrder.LITTLE_ENDIAN).putInt(param[i]);
        else
            Log.e(TAG, "array length is not enough: array is " + array.length + " but need "
                    + cost());
    }
}
