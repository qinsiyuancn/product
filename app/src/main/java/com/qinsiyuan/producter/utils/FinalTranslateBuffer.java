package com.qinsiyuan.producter.utils;

public class FinalTranslateBuffer implements TranslateBuffer{
    private final byte[] buffer;

    public FinalTranslateBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public FinalTranslateBuffer(int size) {
        this.buffer = new byte[size];
    }

    @Override
    public int size() {
        return getBuffer().length;
    }

    @Override
    public byte[] getBuffer() {
        return buffer;
    }
}
