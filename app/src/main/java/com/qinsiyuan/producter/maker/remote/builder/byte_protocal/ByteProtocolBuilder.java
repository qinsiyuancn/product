package com.qinsiyuan.producter.maker.remote.builder.byte_protocal;

import android.util.Log;

import com.qinsiyuan.producter.maker.remote.builder.Builder;
import com.qinsiyuan.producter.maker.remote.builder.byte_protocal.byte_array_getter.ByteArrayGetter;
import com.qinsiyuan.producter.utils.TranslateBuffer;

import java.util.ArrayList;
import java.util.List;

public abstract class ByteProtocolBuilder implements Builder {
    public static final String TAG = "ByteProtocolBuilder";

    public static final ByteProtocolBuilder[] manager
            = new ByteProtocolBuilder[Byte.MAX_VALUE];

    private final List<ByteArrayGetter> getterList;

    @Override
    public void reportPamameter() {
        int i = 0;
        while (i < getterList.size()) {
            if(getterList.get(i) == null){
                break;
            }
            i++;
        }
        ByteArrayGetter getter = reporter.reportGetter(i);
        if(i == getterList.size())
            getterList.add(getter);
        else
            getterList.set(i, getter);
    }

    private void deleteByteArrayGetter(int index) {
        if(index < getterList.size()) {
            getterList.set(index, null);
        }
    }
    private final TranslateBuffer buffer;

    private final GetterReporter reporter;

    public ByteProtocolBuilder(TranslateBuffer buffer, GetterReporter reporter) {
        this.getterList = new ArrayList<ByteArrayGetter>();
        this.buffer = buffer;
        this.reporter = reporter;
    }

    public abstract void getByteArray(ByteArrayGetter getter, byte[] buffer);

    @Override
    public void build(int parameter) {
        if(parameter < 0){
            Log.e(TAG, "build: param < 0 error, param is" + parameter);
            return;
        }
        if(parameter < getterList.size()) {
            getByteArray(getterList.get(parameter), buffer.getBuffer());
            return;
        }
        Log.e(TAG, "build: param >= size error, param is: " + parameter
            +  " size is: " + getterList.size());
    }

    public TranslateBuffer getBuffer() {
        return buffer;
    }
}
