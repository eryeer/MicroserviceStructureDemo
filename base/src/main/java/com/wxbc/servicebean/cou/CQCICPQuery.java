package com.wxbc.servicebean.cou;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-9-27.
 */
@Getter
@Setter
public class CQCICPQuery extends PubKeyInfo {
    private String businessLicenseNum;

    @Override
    public String toString() {
        return "CQCICPQuery{" +
                "businessLicenseNum='" + businessLicenseNum + '\'' +
                "pubKeySigned='" + super.getPubKeySigned() + '\'' +
                "pubKeyBrief='" + super.getPubKeyBrief() +
                '}';
    }
}
