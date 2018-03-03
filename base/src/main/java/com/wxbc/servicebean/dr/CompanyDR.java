package com.wxbc.servicebean.dr;

import com.wxbc.common.BaseInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by administrator on 17-10-11.
 */
@Getter
@Setter
public class CompanyDR extends BaseInfo {

    private String businessLicenseNum;
    private String sceName;

    private Long drBaseValue;
    private Long drShiftRange;
    private Long drShiftRate;
    private Long drFinalValue;

    private String fiBusinessLicenseNum;

    @Override
    public String toString() {
        return "CompanyDR{" +
                "businessLicenseNum='" + businessLicenseNum + '\'' +
                ", sceName='" + sceName + '\'' +
                ", drBaseValue=" + drBaseValue +
                ", drShiftRange=" + drShiftRange +
                ", drShiftRate=" + drShiftRate +
                ", drFinalValue=" + drFinalValue +
                ", fiBusinessLicenseNum='" + fiBusinessLicenseNum + '\'' +
                "} " + super.toString();
    }
}
