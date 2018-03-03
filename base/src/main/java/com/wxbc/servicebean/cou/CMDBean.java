package com.wxbc.servicebean.cou;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-10-20.
 */
@Getter
@Setter
public class CMDBean{
    private String couAddress;
    private String couCMDBrief;
    private String couCMDSigned;
    private String warningBrief;
    private String warningSigned;

    private String pubKeySignedSelf;
    private String pubKeySignedSn;
    private String pubKeySignedCfm;

    private String encCouInfoSelf;
    private String encCouInfoSn;
    private String encCouInfoCfm;

    private long amount;
    private long cmdAmount;

    private BCOSCMDInfo onProcessInfo;

    @Override
    public String toString() {
        return "CMDBean{" +
                "couAddress='" + couAddress + '\'' +
                ", couCMDBrief='" + couCMDBrief + '\'' +
                ", couCMDSigned='" + couCMDSigned + '\'' +
                ", warningBrief='" + warningBrief + '\'' +
                ", warningSigned='" + warningSigned + '\'' +
                ", pubKeySignedSelf='" + pubKeySignedSelf + '\'' +
                ", pubKeySignedSn='" + pubKeySignedSn + '\'' +
                ", pubKeySignedCfm='" + pubKeySignedCfm + '\'' +
                ", amount=" + amount +
                ", cmdAmount=" + cmdAmount +
                ", onProcessInfo=" + onProcessInfo +
                '}';
    }
}