package com.wxbc.servicebean.cou;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BCOSCMDInfo {
    private String snbln;
    private String fibln;
    private String cbln;
    private String snName;
    private String couAddress;
    private String pubKeySignedSn;
    private String pubKeySignedC;
    private String pubKeySignedCfm;
    private long amount;
    private long cmdAmount;

    @Override
    public String toString() {
        return "BCOSCMDInfo{" +
                "snbln='" + snbln + '\'' +
                ", fibln='" + fibln + '\'' +
                ", cbln='" + cbln + '\'' +
                ", snName='" + snName + '\'' +
                ", couAddress='" + couAddress + '\'' +
                ", pubKeySignedSn='" + pubKeySignedSn + '\'' +
                ", pubKeySignedC='" + pubKeySignedC + '\'' +
                ", pubKeySignedCfm='" + pubKeySignedCfm + '\'' +
                ", amount=" + amount +
                ", cmdAmount=" + cmdAmount +
                '}';
    }
}