package com.qinsiyuan.producter.maker;

import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class Maker {
    /*public static abstract class Helper {
        private final String name;

        protected Helper(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        protected abstract Maker get(String json) throws JSONException;
    }*/
    public static final Map<String,Maker> makerManager = new HashMap<String, Maker>();
    /*private static final Map<String,Helper> makerHelperManager
            = new HashMap<String, Helper>();
    private static void init(){
        final Helper[] helpers = {
                new SerialMakerHelper(),
        };
        for(Helper helper : helpers)
            makerHelperManager.put(helper.getName(), helper);
    }
    public static void build(String jsonString) throws JSONException {
        JSONObject json = new JSONObject(jsonString);
        Helper helper = makerHelperManager.get(json.getString("name"));
        if(helper != null) {
            Maker maker = helper.get(json.getString("param"));
            if(maker != null)
                makerManager.put(maker.getName(), maker);
        }
    }*/

    private String getName() {
        return name;
    }

    private final String name;

    public Maker(String name) {
        this.name = name;
    }

    abstract public void make(int parameter) throws IOException;
    abstract public void update();
}
