package com.qinsiyuan.producter.maker.remote.builder.byte_protocal.byte_array_getter;

public class Liquid extends Int2ByteArrayGetter{
    public Liquid(int temperature, int volume) {
        super(getSuperParam(temperature, volume));
    }

    public static int[] getSuperParam(int temperature, int volume){
        final int[] param = {temperature, volume};
        return param;
    }
}
