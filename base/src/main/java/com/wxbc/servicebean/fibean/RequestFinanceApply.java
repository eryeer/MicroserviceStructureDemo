package com.wxbc.servicebean.fibean;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by administrator on 17-9-29.
 */
@Getter
@Setter
public class RequestFinanceApply extends PubKeyInfo {
    private String snBusinessLicenseNumber;
    private String couAddress;
    private Date startTime;
    private Date endTime;

    @Override
    public String toString() {
        return "RequestFinanceApply{" +
                "snBusinessLicenseNumber='" + snBusinessLicenseNumber + '\'' +
                ", couAddress='" + couAddress + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
