package com.qinsiyuan.producter.maker;

import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class Maker {
    /*
     * key format name@server
     * name for maker/product name
     * server for remote device, maybe server of internet or serial to device and so on.
     */
    public static final Map<String,Maker> makerManager = new HashMap<String, Maker>();

    private String getName() {
        return name;
    }

    private final String name;

    public Maker(String name) {
        this.name = name;
    }

    abstract public void make(int parameter) throws IOException;
}
