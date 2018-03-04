package com.wxbc.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IVInfo extends BasePojoInfo{
    private String ivAddress;
    private String name;
    private String ivDesc;
    private UserInfo userInfo;


    @Override
    public String toString() {
        return "IVInfo{" +
                "ivAddress='" + ivAddress + '\'' +
                ", name='" + name + '\'' +
                ", ivDesc='" + ivDesc + '\'' +
                ", userInfo=" + userInfo +
                "} " + super.toString();
    }
}
