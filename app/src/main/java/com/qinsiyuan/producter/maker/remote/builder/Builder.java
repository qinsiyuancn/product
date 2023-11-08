package com.qinsiyuan.producter.maker.remote.builder;

import org.json.JSONException;

public interface Builder {
/*    abstract class Helper{
        private final String name;

        protected Helper(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
        protected abstract Builder create(String json, byte[]buffer) throws JSONException;
    }*/
//    Map<String, Builder> builderManager = new HashMap<String,Builder>();
//    Map<String, Helper> builderHelpManager = new HashMap<String,Helper>();
/*    static void init(){
        final Helper[] helpers = {
                new ByteCommandBuilder.Helper("byte_command_builder"),
        };
        for (Helper helper : helpers){
            builderHelpManager.put(helper.getName(), helper);
        }
    }*/
/*    static void create(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        Helper helper = builderHelpManager.get(jsonObject.getString("name"));
        Builder builder = helper.create();
    }*/
    void build(int parameter);
    void reportPamameter();
}
