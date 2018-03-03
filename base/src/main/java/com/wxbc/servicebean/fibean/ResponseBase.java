package com.wxbc.servicebean.fibean;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-9-29.
 */
@Getter
@Setter
public class ResponseBase {


    public static final int returnCode_200=200;
    public static final int returnCode_400=400;  //insert update failed
    public static final int returnCode_401=401;  //没有数据
    public static final int returnCode_402=402;  //请求校验
    public static final int returnCode_500=500;

    private int returnCode;
    private String returnDesc;

    @Override
    public String toString() {
        return "ResponseBase{" +
                "returnCode=" + returnCode +
                ", returnDesc='" + returnDesc + '\'' +
                '}';
    }
}
