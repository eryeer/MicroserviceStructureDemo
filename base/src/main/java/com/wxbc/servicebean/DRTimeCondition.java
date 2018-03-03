package com.wxbc.servicebean;

import com.wxbc.common.BaseInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-10-12.
 */
@Getter
@Setter
public class DRTimeCondition extends PubKeyInfo {

    private TimeCondition timeCondition;

    private String businessLicenseNum;

    @Override
    public String toString() {
        return "DRTimeCondition{" +
                "timeCondition=" + timeCondition +
                ", businessLicenseNum='" + businessLicenseNum + '\'' +
                '}';
    }
}
