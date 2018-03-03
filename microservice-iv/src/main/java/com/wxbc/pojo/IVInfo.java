package com.wxbc.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IVInfo {
    private Integer id;
    private String ivAddress;
    private String name;
    private String ivDesc;
    private UserInfo userInfo;

    @Override
    public String toString() {
        return "IVInfo{" +
                "id=" + id +
                ", ivAddress='" + ivAddress + '\'' +
                ", name='" + name + '\'' +
                ", ivDesc='" + ivDesc + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
