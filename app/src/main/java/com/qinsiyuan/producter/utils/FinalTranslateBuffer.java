package com.qinsiyuan.producter.utils;

public class FinalTranslateBuffer extends TranslateBuffer{
    public FinalTranslateBuffer(int size) {
        super(size);
    }

    @Override
    public int size() {
        return getBuffer().length;
    }
}
