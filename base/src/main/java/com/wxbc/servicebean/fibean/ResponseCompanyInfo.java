package com.wxbc.servicebean.fibean;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.HashMap;
import java.util.List;

/**
 * Created by administrator on 17-9-29.
 */
@Getter
@Setter
public class ResponseCompanyInfo extends ResponseBase {


    private String accountOpenBank;  //开户行
    private String sceName; //企业名称
    private String accountName;//户名
    private String account; //账号信息
    @Length(min = 18, max = 18)
    private String businessLicenseNum; //统一社会信用码

    private String companyType;

    private List<String> phoneNum;
    private Long drBaseValue;
    private Long drShiftRange;
    private Long drFinalValue;
    private List<String> encCOUInfo;
    private HashMap<String, String> addresses;

    private String pubKeySignedC;


    public ResponseCompanyInfo() {
        this.setReturnCode(returnCode_200);
    }

    @Override
    public String toString() {
        return "ResponseCompanyInfo{" +
                "accountOpenBank='" + accountOpenBank + '\'' +
                ", sceName='" + sceName + '\'' +
                ", accountName='" + accountName + '\'' +
                ", account='" + account + '\'' +
                ", businessLicenseNum='" + businessLicenseNum + '\'' +
                ", companyType='" + companyType + '\'' +
                ", phoneNum=" + phoneNum +
                ", drFinalValue=" + drFinalValue +
                ", drBaseValue=" + drBaseValue +
                ", drShiftRange=" + drShiftRange +
                ", addresses=" + addresses +
                ", pubKeySignedC='" + pubKeySignedC + '\'' +
                "} " + super.toString();
    }
}


