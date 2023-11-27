package com.qinsiyuan.producter.utils;

public class SetableTranslateBuffer implements TranslateBuffer{

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public SetableTranslateBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public SetableTranslateBuffer() {
        this.buffer = null;
    }

    public SetableTranslateBuffer(int size) {
        this.buffer = new byte[size];
    }
    private byte[] buffer;

    @Override
    public int size() {
        return buffer == null ? 0 : buffer.length;
    }

    @Override
    public byte[] getBuffer() {
        return buffer;
    }
}
