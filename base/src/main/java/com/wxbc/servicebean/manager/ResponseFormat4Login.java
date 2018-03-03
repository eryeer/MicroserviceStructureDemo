package com.wxbc.servicebean.manager;

import com.wxbc.common.ReturnCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-9-14.
 */
@Setter
@Getter
public class ResponseFormat4Login {

    private int returnCode;

    private String returnDesc;

    private SCERegisterInfo sceRegisterInfo;

    private CompanyInfo companyInfo;

    private UserKeyInfo userKeyInfo;

    public ResponseFormat4Login() {

    }

    public ResponseFormat4Login(ReturnCode returnCode) {
        setReturnCode(returnCode.getValue());
        setReturnDesc(returnCode.getDesc());
    }

    public void setInfo(SCERegisterInfo sceRegisterInfo, CompanyInfo companyInfo, UserKeyInfo userKeyInfo) {
        this.setUserKeyInfo(userKeyInfo);
        this.setSceRegisterInfo(sceRegisterInfo);
        this.setCompanyInfo(companyInfo);
    }

    @Override
    public String toString() {
        return "ResponseFormat4Login{" +
                "returnCode=" + returnCode +
                ", returnDesc='" + returnDesc + '\'' +
                ", sceRegisterInfo=" + sceRegisterInfo +
                ", companyInfo=" + companyInfo +
                ", userKeyInfo=" + userKeyInfo +
                '}';
    }
}
