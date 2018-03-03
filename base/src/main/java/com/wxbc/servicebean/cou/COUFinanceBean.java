package com.wxbc.servicebean.cou;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-10-17.
 */
@Getter
@Setter
public class COUFinanceBean {

    private String couAddress;
    private String couSigned;
    private String couBrief;
    private String couDFCSigned;
    private String couDFCBrief;

    private String encryptCOUSelf;
    private String encryptCOUCA;

    private String pubKeySignedSelf;
    private String pubKeySignedCA;

    private DFCAgreementInfo dfcAgreementInfo;

    @Override
    public String toString() {
        return "COUFinanceBean{" +
                "couAddress='" + couAddress + '\'' +
                ", couSigned='" + couSigned + '\'' +
                ", couBrief='" + couBrief + '\'' +
                ", couDFCSigned='" + couDFCSigned + '\'' +
                ", couDFCBrief='" + couDFCBrief + '\'' +
                ", pubKeySignedSelf='" + pubKeySignedSelf + '\'' +
                ", pubKeySignedCA='" + pubKeySignedCA +
                '}';
    }
}
