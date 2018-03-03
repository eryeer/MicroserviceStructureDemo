package com.wxbc.servicebean.fibean;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-9-29.
 */
@Getter
@Setter
public class RequestCompanyInfo extends PubKeyInfo {
    private String snBusinessLicenseNumber;

    @Override
    public String toString() {
        return "RequestCompanyInfo{" +
                "snBusinessLicenseNumber='" + snBusinessLicenseNumber + '\'' +
                '}';
    }
}
