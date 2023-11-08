package com.qinsiyuan.producter.maker.remote.builder.byte_protocal.byte_array_getter;

public class Liquid extends Int2ByteArrayGetter{
    public Liquid(int temperature, int volume) {
        super(liquid2intArray(temperature, volume));
    }
    public static int[] liquid2intArray(int temperature, int volume){
        final int[] param = {temperature, volume};
        return param;
    }
}
