package com.wxbc.servicebean.fibean;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: ZhengJiao
 * @Description:
 * @Date: created in 上午11:01 17-12-11
 */
@Setter
@Getter
public class RequestDRShiftRangeInfo extends PubKeyInfo {
    private String snbln;
    private Long drShiftRange;
    private String drShiftRangeSigned;

    @Override
    public String toString() {
        return "RequestDRShiftRangeInfo{" +
                "snbln='" + snbln + '\'' +
                ", drShiftRange=" + drShiftRange +
                ", drShiftRangeSigned='" + drShiftRangeSigned + '\'' +
                "} " + super.toString();
    }
}