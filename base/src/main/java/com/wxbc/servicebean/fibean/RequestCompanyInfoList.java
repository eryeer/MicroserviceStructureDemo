package com.wxbc.servicebean.fibean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Zhaochen
 * @Description:
 * @Date: created in 下午2:11 17-12-7
 */
@Setter
@Getter
public class RequestCompanyInfoList extends PubKeyInfo {

    @JsonFormat(pattern = "yyyyMMdd")
    private Date startTime;
    @JsonFormat(pattern = "yyyyMMdd")
    private Date endTime;
    private Integer drBaseValueCondition;

    @Override
    public String toString() {
        return "RequestCompanyInfoList{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", drBaseValueCondition=" + drBaseValueCondition +
                "} " + super.toString();
    }
}