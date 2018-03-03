package com.wxbc.servicebean.cou;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-10-20.
 */
@Getter
@Setter
public class CMDDoneBean {
    private String couAddress;
    private String couCMDBrief;
    private String couCMDSigned;

    private String pubKeySignedSelf;
    private String pubKeySignedC;

    private String encCouInfoSelf;
    private String encCouInfoC;

    private long amount;
    private long cmdAmount;

    @Override
    public String toString() {
        return "CMDDoneBean{" +
                "couAddress='" + couAddress + '\'' +
                ", couCMDBrief='" + couCMDBrief + '\'' +
                ", couCMDSigned='" + couCMDSigned + '\'' +
                ", pubKeySignedSelf='" + pubKeySignedSelf + '\'' +
                ", pubKeySignedC='" + pubKeySignedC + '\'' +
                ", amount=" + amount +
                ", cmdAmount=" + cmdAmount +
                '}';
    }
}
