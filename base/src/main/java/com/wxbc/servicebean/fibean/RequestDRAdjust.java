package com.wxbc.servicebean.fibean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by administrator on 17-9-29.
 */
@Getter
@Setter
public class RequestDRAdjust extends PubKeyInfo {
    private String snBusinessLicenseNumber;
    @JsonFormat(pattern = "yyyyMMdd")
    private Date startTime;
    @JsonFormat(pattern = "yyyyMMdd")
    private Date endTime;

    @Override
    public String toString() {
        return "RequestDRAdjust{" +
                "snBusinessLicenseNumber='" + snBusinessLicenseNumber + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
