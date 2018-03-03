package com.wxbc.servicebean.manager;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Zhaochen
 * @Description:
 * @Date: created in 6:53 PM 1/17/18
 */
@Setter
@Getter
public class CompanyBizDataInfo {
    private String companyName;
    private String businessLicenseNum;
    private String regNO;
    private String companyType;
    private String personName;
    private Integer isLegPerson;
    private Integer isHolder;
    private Double conRatio;
    private Double conAmount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date establishDate;
    private Double regCapital;
    private String regOrg;
    private String companyStatus;
    private String dom;
    private String opScope;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date insertTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @Override
    public String toString() {
        return "CompanyBizDataInfo{" +
                "companyName='" + companyName + '\'' +
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
                ", insertTime=" + insertTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
