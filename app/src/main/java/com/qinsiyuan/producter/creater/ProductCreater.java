package com.qinsiyuan.producter.creater;

import com.qinsiyuan.producter.Product;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public interface ProductCreater {
    Map<String, ProductCreater> manager = new HashMap<String,ProductCreater>();
    Product create(String name, String content) throws IOException;
}
