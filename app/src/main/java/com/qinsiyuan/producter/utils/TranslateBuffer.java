package com.qinsiyuan.producter.utils;

public abstract class TranslateBuffer {
    private final byte[] buffer;

    protected TranslateBuffer(int size) {
        this.buffer = new byte[size];
    }

    public abstract int size();

    public byte[] getBuffer() {
        return buffer;
    }
}
