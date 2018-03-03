package com.wxbc.servicebean.manager;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Zhaochen
 * @Description:
 * @Date: created in 2:19 PM 1/18/18
 */
@Setter
@Getter
public class ResponseCompanyBiz {
    private int retCode;
    private String retMsg;
    private List<CompanyBizDataInfo> data;

    @Override
    public String toString() {
        return "ResponseCompanyBiz{" +
                "retCode=" + retCode +
                ", retMsg='" + retMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
