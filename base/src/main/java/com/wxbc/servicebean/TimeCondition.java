package com.wxbc.servicebean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by administrator on 17-10-12.
 */
@Getter
@Setter
public class TimeCondition {
    private Date startTime;
    private Date endTime;

    @Override
    public String toString() {
        return "TimeCondition{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
