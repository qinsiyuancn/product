package com.qinsiyuan.producter.maker.remote.builder.byte_protocal;

import android.util.Log;

import com.qinsiyuan.producter.maker.remote.builder.Builder;
import com.qinsiyuan.producter.maker.remote.builder.byte_protocal.byte_array_getter.ByteArrayGetter;
import com.qinsiyuan.producter.utils.SetableTranslateBuffer;
import com.qinsiyuan.producter.utils.TranslateBuffer;

import java.util.ArrayList;
import java.util.List;

public class ByteProtocolBuilder implements Builder {
    public static final String TAG = "ByteProtocolBuilder";

    private final List<ByteArrayGetter> getterList;

    public void deleteByteArrayGetter(int index) {
        if(index < getterList.size()) {
            getterList.set(index, null);
        }
    }
    public int addArrayGetter(ByteArrayGetter getter){
        for (int i = 0; i < getterList.size(); i++){
            if(getterList.get(i) == null){
                getterList.set(i, getter);
                return i;
            }
        }
        getterList.add(getter);
        return getterList.size() - 1;
    }
    private final SetableTranslateBuffer buffer;

    public ByteProtocolBuilder(SetableTranslateBuffer buffer) {
        this.getterList = new ArrayList<>();
        this.buffer = buffer;
    }

    @Override
    public void build(int parameter) {
        if(parameter < 0){
            Log.e(TAG, "build: param < 0 error, param is" + parameter);
            return;
        }
        if(parameter < getterList.size()) {
            ByteArrayGetter getter = getterList.get(parameter);
            if(buffer.size() == 0)
                buffer.setBuffer(new byte[getter.cost()]);
//            getByteArray(getter, buffer.getBuffer());
            getter.setToByteArray(buffer.getBuffer(),0);
            return;
        }
        Log.e(TAG, "build: param >= size error, param is: " + parameter
            +  " size is: " + getterList.size());
    }

    public TranslateBuffer getBuffer() {
        return buffer;
    }
}
