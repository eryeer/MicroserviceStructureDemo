package com.wxbc.servicebean.cou;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-10-20.
 */
@Getter
@Setter
public class ApplyCMDBean {
    private String couAddress;
    private String couBrief;
    private String couSigned;
    private String couCMDBrief;
    private String couCMDSigned;
    private String warningBrief;
    private String warningSigned;

    private String pubKeySignedSelf;
    private String pubKeySignedC;

    private String encCouInfoSelf;
    private String encCouInfoC;

    @Override
    public String toString() {
        return "ApplyCMDBean{" +
                "couAddress='" + couAddress + '\'' +
                ", couBrief='" + couBrief + '\'' +
                ", couSigned='" + couSigned + '\'' +
                ", couCMDBrief='" + couCMDBrief + '\'' +
                ", couCMDSigned='" + couCMDSigned + '\'' +
                ", warningBrief='" + warningBrief + '\'' +
                ", warningSigned='" + warningSigned + '\'' +
                ", pubKeySignedSelf='" + pubKeySignedSelf + '\'' +
                ", pubKeySignedC='" + pubKeySignedC + '\'' +
                '}';
    }
}