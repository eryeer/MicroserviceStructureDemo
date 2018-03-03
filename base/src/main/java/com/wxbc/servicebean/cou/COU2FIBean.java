package com.wxbc.servicebean.cou;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-10-19.
 */
@Setter
@Getter
public class COU2FIBean {

    private String couAddress;
    private String couDFCBrief;
    private String couDFCSigned;
    private String warningBrief;
    private String warningSigned;

    private String pubKeySignedSelf;
    private String pubKeySignedSn;
    private String pubKeySignedFI;
    private String pubKeySignedCfm;
    private String pubKeySignedR;

    private String encCouInfoSelf;
    private String encCouInfoSn;
    private String encCouInfoFI;
    private String encCouInfoCfm;
    private String encCouInfoR;

    private BCOSDFCInfo onProcessInfo;
    private DFCAgreementInfo dfcAgreementInfo;

    @Override
    public String toString() {
        return "COU2FIBean{" +
                "couAddress='" + couAddress + '\'' +
                ", couDFCBrief='" + couDFCBrief + '\'' +
                ", couDFCSigned='" + couDFCSigned + '\'' +
                ", warningBrief='" + warningBrief + '\'' +
                ", warningSigned='" + warningSigned + '\'' +
                ", pubKeySignedSelf='" + pubKeySignedSelf + '\'' +
                ", pubKeySignedSn='" + pubKeySignedSn + '\'' +
                ", pubKeySignedFI='" + pubKeySignedFI + '\'' +
                ", pubKeySignedCfm='" + pubKeySignedCfm + '\'' +
                ", onProcessInfo=" + onProcessInfo +
                '}';
    }
}
