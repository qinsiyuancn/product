package com.qinsiyuan.producter.maker.remote.server;

import android.util.Log;

import com.qinsiyuan.producter.utils.TranslateBuffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Server{
    public static final Map<String,Server> manager = new HashMap<>();

    public final InputStream inputStream;
    public final OutputStream outputStream;

    public static final String TAG = "StreamServer";
    public Server(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
}
