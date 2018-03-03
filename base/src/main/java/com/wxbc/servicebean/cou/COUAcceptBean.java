package com.wxbc.servicebean.cou;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-10-11.
 */
@Getter
@Setter
public class COUAcceptBean {

    private String couSigned;
    private String couBrief;
    private String couAddress;
    private long amount;

    private String pubKeySignedSelf;
    private String pubKeySignedTo;
    private String pubKeySignedCfm;
    private String encryptCOUSelf;
    private String encryptCOUTo;
    private String encCouInfoCfm;
    private String warningBrief;
    private String warningSigned;  //verify

    @Override
    public String toString() {
        return "COUAcceptBean{" +
                "couSigned='" + couSigned + '\'' +
                ", couBrief='" + couBrief + '\'' +
                ", couAddress='" + couAddress + '\'' +
                ", amount=" + amount +
                ", pubKeySignedSelf='" + pubKeySignedSelf + '\'' +
                ", pubKeySignedTo='" + pubKeySignedTo + '\'' +
                ", pubKeySignedCfm='" + pubKeySignedCfm + '\'' +
                ", warningBrief='" + warningBrief + '\'' +
                ", warningSigned='" + warningSigned + '\'' +
                '}';
    }
}
