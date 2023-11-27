package com.qinsiyuan.producter.maker.remote.builder;

import java.util.HashMap;
import java.util.Map;

public interface Builder {
    /*
     * key format: name.type
     * name for builder name/product name
     * type for protocol type
     */
    Map<String , Builder> manager = new HashMap<>();
    void build(int parameter);
}
