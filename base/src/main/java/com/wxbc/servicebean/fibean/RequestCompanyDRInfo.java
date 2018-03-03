package com.wxbc.servicebean.fibean;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Zhaochen
 * @Description:
 * @Date: created in 上午11:01 17-12-7
 */
@Setter
@Getter
public class RequestCompanyDRInfo extends PubKeyInfo {
    private String snbln;
    private Long drBaseValue;
    private String drBaseValueSigned;

    @Override
    public String toString() {
        return "RequestCompanyDRInfo{" +
                "snbln='" + snbln + '\'' +
                ", drBaseValue=" + drBaseValue +
                ", drBaseValueSigned='" + drBaseValueSigned + '\'' +
                "} " + super.toString();
    }
}