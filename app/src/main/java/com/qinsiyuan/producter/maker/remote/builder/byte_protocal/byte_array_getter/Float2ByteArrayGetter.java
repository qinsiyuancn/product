package com.qinsiyuan.producter.maker.remote.builder.byte_protocal.byte_array_getter;

import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Float2ByteArrayGetter implements ByteArrayGetter{
    public static final String TAG = "Float2ByteArrayGetter";
    private final float[] param;

    public Float2ByteArrayGetter(float[] param) {
        this.param = param;
    }

    @Override
    public int cost() {
        return param.length * Float.BYTES;
    }

    @Override
    public void setToByteArray(byte[] array, int startIndex) {
        if(array.length < cost())
            for (int i = 0; i < param.length; i++)
                ByteBuffer.wrap(array, startIndex + i * Integer.BYTES, Integer.BYTES)
                        .order(ByteOrder.LITTLE_ENDIAN).putFloat(param[i]);
        else
            Log.e(TAG, "array length is not enough: array is " + array.length + " but need "
                    + cost());
    }
}
