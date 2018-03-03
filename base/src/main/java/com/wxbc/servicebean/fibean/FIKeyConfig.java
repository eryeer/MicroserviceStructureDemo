package com.wxbc.servicebean.fibean;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-10-9.
 */
@Getter
@Setter
public class FIKeyConfig extends PubKeyInfo {
    private String tag;
    private String pubKey;
    private String recPubKey;

    private String businessLicenseNum;
    private String companyName;

    @Override
    public String toString() {
        return "FIKeyConfig{" +
                "tag='" + tag + '\'' +
                ", pubKey='" + pubKey + '\'' +
                ", recPubKey='" + recPubKey + '\'' +
                ", businessLicenseNum='" + businessLicenseNum + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
