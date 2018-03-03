package com.wxbc.servicebean.cou;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-9-26.
 */
@Getter
@Setter
public class COUPay{
    private String couSigned;
    private String couBrief;
    private String couAddress;
    private long amount;

    private String encryptCOUSelf;
    private String encryptCOUTo;
    private String encryptCOUCfm;

    private String encryptCOUCa;
    private String pubKeySignedCa;

    @Override
    public String toString() {
        return "COUPay{" +
                "couSigned='" + couSigned + '\'' +
                ", couBrief='" + couBrief + '\'' +
                ", couAddress='" + couAddress + '\'' +
                ", amount=" + amount +
                ", pubKeySignedCa='" + pubKeySignedCa + '\'' +
                '}';
    }
}
