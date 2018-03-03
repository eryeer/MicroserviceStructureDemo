package com.wxbc.servicebean.fibean;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by administrator on 17-10-9.
 */
@Getter
@Setter
public class RequestLoanLog extends PubKeyInfo {
    private Date startTime;
    private Date endTime;

    @Override
    public String toString() {
        return "RequestLoanLog{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
