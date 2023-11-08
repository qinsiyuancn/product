package com.qinsiyuan.producter.maker.remote.builder.byte_protocal.byte_array_getter;

import android.util.Log;

public class BytesArrayCopy implements ByteArrayGetter{
    public static final String TAG = "BytesArrayCopy";
    private final byte[] param;

    public BytesArrayCopy(byte[] param) {
        this.param = param;
    }

    @Override
    public int cost() {
        return param.length * Byte.BYTES;
    }

    @Override
    public void setToByteArray(byte[] array, int startIndex) {
        if (array.length < param.length)
            System.arraycopy(param,0, array, startIndex, param.length);
        else
            Log.e(TAG, "array length is not enough: array is " + array.length + " but need "
            + cost());
    }
}
