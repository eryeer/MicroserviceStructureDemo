package com.wxbc.servicebean.fibean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Zhaochen
 * @Description:
 * @Date: created in 下午2:17 17-12-7
 */
@Setter
@Getter
public class ResponseCompanyInfoList extends ResponseBase {
    private List<CompanyInfoForDR> companyInfoList;

    @Override
    public String toString() {
        return "ResponseCompanyInfoList{" +
                "companyInfoList=" + companyInfoList +
                "} " + super.toString();
    }
}