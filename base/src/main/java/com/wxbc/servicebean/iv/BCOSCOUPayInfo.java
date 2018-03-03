package com.wxbc.servicebean.iv;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by administrator on 17-9-29.
 */
@Getter
@Setter
public class BCOSCOUPayInfo {
    
    private String ivAddress;
    private String from;
    private String to;
    private List<COUListInfo> couList;

    @Override
    public String toString() {
        return "BCOSCOUPayInfo{" +
                "ivAddress='" + ivAddress + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", couList=" + couList +
                '}';
    }
}

