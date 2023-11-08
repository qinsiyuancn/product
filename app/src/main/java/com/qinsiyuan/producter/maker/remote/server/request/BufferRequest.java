package com.qinsiyuan.producter.maker.remote.server.request;

import com.qinsiyuan.producter.utils.FinalTranslateBuffer;
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
        stream.write(buffer.getBuffer(), 0, buffer.size());
    }
}
