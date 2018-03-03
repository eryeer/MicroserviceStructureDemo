package com.wxbc.servicebean.dr;

import com.wxbc.common.BaseInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-10-14.
 */
@Getter
@Setter
public class CompanyDRMicroAdjustLog extends BaseInfo {
    private String businessLicenseNum;
    private String sceName;
    private int finalValue;

    @Override
    public String toString() {
        return "CompanyDRMicroAdjustLog{" +
                "businessLicenseNum='" + businessLicenseNum + '\'' +
                ", sceName='" + sceName + '\'' +
                ", finalValue=" + finalValue +
                '}';
    }
}
