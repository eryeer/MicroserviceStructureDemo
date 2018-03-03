package com.wxbc.servicebean.manager;

import com.wxbc.common.BaseInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Zhaochen
 * @Description:
 * @Date: created in 6:58 PM 1/17/18
 */
@Getter
@Setter
public class CompanyBizDataTableInfo extends BaseInfo{

    private Date nextUpdateDate;
    private String companyName;
    private String businessLicenseNum;
    private String regNO;
    private String companyType;
    private String personName;
    private Integer isLegPerson;
    private Integer isHolder;
    private Integer conRatio;
    private Long conAmount;
    private Date establishDate;
    private Long regCapital;
    private String regOrg;
    private String companyStatus;
    private String dom;
    private String opScope;
    private Date companyInsertTime;
    private Date companyUpdateTime;

    @Override
    public String toString() {
        return "CompanyBizDataTableInfo{" +
                "nextUpdateDate=" + nextUpdateDate +
                ", companyName='" + companyName + '\'' +
                ", businessLicenseNum='" + businessLicenseNum + '\'' +
                ", regNO='" + regNO + '\'' +
                ", companyType='" + companyType + '\'' +
                ", personName='" + personName + '\'' +
                ", isLegPerson=" + isLegPerson +
                ", isHolder=" + isHolder +
                ", conRatio=" + conRatio +
                ", conAmount=" + conAmount +
                ", establishDate=" + establishDate +
                ", regCapital=" + regCapital +
                ", regOrg='" + regOrg + '\'' +
                ", companyStatus='" + companyStatus + '\'' +
                ", dom='" + dom + '\'' +
                ", opScope='" + opScope + '\'' +
                ", companyInsertTime=" + companyInsertTime +
                ", companyUpdateTime=" + companyUpdateTime +
                "} " + super.toString();
    }
}
