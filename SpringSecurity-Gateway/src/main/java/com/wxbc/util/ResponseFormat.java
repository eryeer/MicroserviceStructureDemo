package com.wxbc.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by leo on 2017/8/10.
 */
public class ResponseFormat<T> {
    @Setter @Getter
    private int returnCode;
    @Setter @Getter
    private String returnDesc;
    @Setter @Getter
    private List<T> items;


    public ResponseFormat(){

    }

    public ResponseFormat(ReturnCode returnCode){
        this(returnCode, null);
    }
    public ResponseFormat(ReturnCode returnCode, List<T> items){
        setReturnCode(returnCode.getValue());
        setReturnDesc(returnCode.getDesc());
        setItems(items);
    }
    public void setReturnCodeEx(ReturnCode returnCode){
        setReturnCode(returnCode.getValue());
        setReturnDesc(returnCode.getDesc());
    }

    public ResponseFormat(int returnCode, String returnDesc, List<T> items) {
        this.returnCode = returnCode;
        this.returnDesc = returnDesc;
        this.items = items;
    }

    @Override
    public String toString() {
        return "ResponseFormat{" +
                "returnCode=" + returnCode +
                ", returnDesc='" + returnDesc + '\'' +
                ", items=" + items +
                '}';
    }
}
