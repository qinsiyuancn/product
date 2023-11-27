package com.qinsiyuan.producter.maker.remote.builder.byte_protocal.byte_array_getter;

public class GetterGroup implements ByteArrayGetter{
    private final ByteArrayGetter[] getterList;

    public GetterGroup(ByteArrayGetter[] getterList) {
        this.getterList = getterList;
    }

    @Override
    public int cost() {
        int ret = 0;
        for (ByteArrayGetter getter :getterList){
            ret += getter.cost();
        }
        return ret;
    }

    @Override
    public void setToByteArray(byte[] array, int startIndex) {
        for (ByteArrayGetter getter : getterList){
            if(startIndex  + getter.cost() < array.length) {
                getter.setToByteArray(array, startIndex);
                startIndex += getter.cost();
            }
            else
                break;
        }
    }
}
