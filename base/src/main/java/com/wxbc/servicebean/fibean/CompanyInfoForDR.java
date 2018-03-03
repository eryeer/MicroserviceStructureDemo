package com.wxbc.servicebean.fibean;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Zhaochen
 * @Description:
 * @Date: created in 下午2:22 17-12-7
 */
@Setter
@Getter
public class CompanyInfoForDR {
    private String businessLicenseNumber;
    private String sceName;
    private Long drBaseValue;
    private Long drShiftRange;
    private Long drFinalValue;

    @Override
    public String toString() {
        return "CompanyInfoForDR{" +
                "businessLicenseNumber='" + businessLicenseNumber + '\'' +
                ", sceName='" + sceName + '\'' +
                ", drBaseValue=" + drBaseValue +
                ", drShiftRange=" + drShiftRange +
                ", drFinalValue=" + drFinalValue +
                '}';
    }
}