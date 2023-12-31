package com.qinsiyuan.producter.maker.remote;

import androidx.annotation.NonNull;

import com.qinsiyuan.producter.maker.remote.builder.Builder;
import com.qinsiyuan.producter.maker.Maker;
import com.qinsiyuan.producter.maker.remote.server.request.Request;

import java.io.IOException;

public class RemoteMaker extends Maker {

    private final Request request;
    private final Builder builder;
    public RemoteMaker(String name, Builder builder, Request request) {
        super(name);
        this.request = request;
        this.builder = builder;
    }

    static class ObjectIOException extends IOException{
        private final String why;

        ObjectIOException(String why) {
            this.why = why;
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " " +why;
        }
    }
    @Override
    public void make(int parameter) throws IOException {
        if(builder == null) throw new ObjectIOException("builder is null");
        if(request == null) throw new ObjectIOException("server is null");
        builder.build(parameter);
        request.request();
    }
}
