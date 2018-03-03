package com.wxbc.servicebean.manager;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Zhaochen
 * @Description:
 * @Date: created in 下午12:36 17-11-20
 */

@Setter
@Getter
public class SimpleCompanyInfo {

    private Integer id;
    private String companyType;
    private String SCEName; //企业名称
    private String businessLicenseNum; //统一社会信用码

    @Override
    public String toString() {
        return "SimpleCompanyInfo{" +
                "id=" + id +
                ", companyType='" + companyType + '\'' +
                ", SCEName='" + SCEName + '\'' +
                ", businessLicenseNum='" + businessLicenseNum + '\'' +
                '}';
    }
}