package com.wxbc.servicebean.cou;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BCOSDFCInfo{
    private String snbln;
    private String fibln;
    private String cbln;
    private String snName;
    private String couAddress;
    private String encCOUInfoFI;
    private String pubKeySignedSn;
    private String pubKeySignedC;
    private DFCAgreementInfo dfcAgreementInfo;

    @Override
    public String toString() {
        return "BCOSDFCInfo{" +
                "snbln='" + snbln + '\'' +
                ", fibln='" + fibln + '\'' +
                ", cbln='" + cbln + '\'' +
                ", snName='" + snName + '\'' +
                ", couAddress='" + couAddress + '\'' +
                ", pubKeySignedSn='" + pubKeySignedSn + '\'' +
                ", pubKeySignedC='" + pubKeySignedC + '\'' +
                '}';
    }
}