package com.wxbc.servicebean.cou;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 * Created by administrator on 17-9-27.
 */
@Getter
@Setter
public class CQLine extends PubKeyInfo {
    @Length(max = 80,min = 18)
    private String businessLicenseNum;
    private long cqAdjust;

    private String cqSigned;

    @Override
    public String toString() {
        return "CQLine{" +
                "businessLicenseNum='" + businessLicenseNum + '\'' +
                ", cqAdjust=" + cqAdjust +
                ", cqSigned='" + cqSigned + '\'' +
                "pubKeySigned='" + super.getPubKeySigned() + '\'' +
                "pubKeyBrief='" + super.getPubKeyBrief() +
                '}';
    }
}
