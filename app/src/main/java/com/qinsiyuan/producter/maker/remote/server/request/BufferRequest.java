package com.qinsiyuan.producter.maker.remote.server.request;

import com.qinsiyuan.producter.utils.TranslateBuffer;

import java.io.IOException;
import java.io.OutputStream;

public class BufferRequest implements Request{
    private final TranslateBuffer buffer;
    private final OutputStream stream;
    public BufferRequest(TranslateBuffer buffer, OutputStream stream) {
        this.buffer = buffer;
        this.stream = stream;
    }
    @Override
    public void request() throws IOException {
        byte[] msg = buffer.getBuffer();
        int size = buffer.size();
        if(msg != null && size != 0) {

            stream.write(msg, 0, size);
            stream.flush();
        }
    }
}
