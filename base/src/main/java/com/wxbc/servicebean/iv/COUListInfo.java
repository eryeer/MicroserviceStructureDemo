package com.wxbc.servicebean.iv;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-9-29.
 */
@Getter
@Setter
public class COUListInfo {
    private String fromCOUAddress;
    private long fromCOUAmount;
    private String toCOUAddress;
    private long toCOUAmount;
    private String selfCOUAddress;
    private long selfCOUAmount;

    private String cbln;
    private String fibln;

    @Override
    public String toString() {
        return "COUListInfo{" +
                "fromCOUAddress='" + fromCOUAddress + '\'' +
                ", fromCOUAmount=" + fromCOUAmount +
                ", toCOUAddress='" + toCOUAddress + '\'' +
                ", toCOUAmount=" + toCOUAmount +
                ", selfCOUAddress='" + selfCOUAddress + '\'' +
                ", selfCOUAmount=" + selfCOUAmount +
                ", cbln='" + cbln + '\'' +
                ", fibln='" + fibln + '\'' +
                '}';
    }
}
