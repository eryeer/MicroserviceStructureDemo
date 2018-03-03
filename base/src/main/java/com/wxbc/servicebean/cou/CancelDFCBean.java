package com.wxbc.servicebean.cou;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-10-19.
 */
@Getter
@Setter
public class CancelDFCBean {
    private String couSigned;
    private String couBrief;
    private String couAddress;
    private String encCOUInfoSelf;
    private String pubKeySignedSelf;

    @Override
    public String toString() {
        return "CancelDFCBean{" +
                "couSigned='" + couSigned + '\'' +
                ", couBrief='" + couBrief + '\'' +
                ", couAddress='" + couAddress + '\'' +
                ", pubKeySignedSelf='" + pubKeySignedSelf + '\'' +
                '}';
    }
}