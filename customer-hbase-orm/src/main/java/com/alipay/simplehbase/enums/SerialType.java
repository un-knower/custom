package com.alipay.simplehbase.enums;

public enum SerialType {

    SERIALNUM(1,"pss:serial_num");
    
	

    private int index;

    private String value;

    SerialType(int index,String value){
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
