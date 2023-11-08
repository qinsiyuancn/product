package com.qinsiyuan.producter;

import com.qinsiyuan.producter.maker.Maker;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Product {

    public static Product build(String jsonString) throws JSONException {
        JSONObject object = new JSONObject(jsonString);
        return new Product(object.getString("name"),
                object.getString("content"),
                Maker.makerManager.get(object.getString("maker")),
                object.getInt("parameter"));
    }

    private final String name;
    private final Maker maker;
    private final int parameter;
    private final String content;

    public Product(String name, String content, Maker maker, int parameter) {
        this.name = name;
        this.maker = maker;
        this.parameter = parameter;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void make() throws IOException {
        maker.make(parameter);
    }
}
