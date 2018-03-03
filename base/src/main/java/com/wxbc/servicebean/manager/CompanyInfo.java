package com.wxbc.servicebean.manager;

import com.wxbc.common.BaseInfo;
import com.wxbc.common.CommonConst;
import com.wxbc.servicebean.contract.ContractInfo;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

/**
 * Created by administrator on 17-9-6.
 */
@Getter
@Setter
public class CompanyInfo extends BaseInfo {

    @Pattern(regexp = CommonConst.ACCOUNT_OPEN_BANK_REGEX)
    private String accountOpenBank;  //开户行
    @Pattern(regexp = CommonConst.SCE_NAME_REGEX)
    private String SCEName; //企业名称
    @Pattern(regexp = CommonConst.ACCOUNT_NAME_REGEX)
    private String accountName;//户名
    @Pattern(regexp = CommonConst.ACCOUNT_REGEX)
    private String account; //账号信息
    @Pattern(regexp = CommonConst.BUSINESS_LICENSE_NUM_REGEX)
    private String businessLicenseNum; //统一社会信用码

    private String companyType;

    private String remark;
    private Long finvalue;

    private String businessLicenseFileID;
    private String bankAccountCertificateFileID;
    private String organizationCreditCertificateFileID;
    private String authorizationCreditInquiryFileID;
    private String legalRepresentativeIDFileID;
    private String financialReportFileID;
    private String constitutionID;
    private Date confirmDate;

    private List<UserKeyInfo> pubKeyInfo;

    private List<ContractInfo> contractInfo;

    private List<LoginCodeInfo> loginCodeInfo;

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "accountOpenBank='" + accountOpenBank + '\'' +
                ", SCEName='" + SCEName + '\'' +
                ", accountName='" + accountName + '\'' +
                ", account='" + account + '\'' +
                ", businessLicenseNum='" + businessLicenseNum + '\'' +
                ", companyType='" + companyType + '\'' +
                ", remark='" + remark + '\'' +
                ", finvalue=" + finvalue +
                ", businessLicenseFileID='" + businessLicenseFileID + '\'' +
                ", bankAccountCertificateFileID='" + bankAccountCertificateFileID + '\'' +
                ", organizationCreditCertificateFileID='" + organizationCreditCertificateFileID + '\'' +
                ", authorizationCreditInquiryFileID='" + authorizationCreditInquiryFileID + '\'' +
                ", legalRepresentativeIDFileID='" + legalRepresentativeIDFileID + '\'' +
                ", financialReportFileID='" + financialReportFileID + '\'' +
                ", constitutionID='" + constitutionID + '\'' +
                ", confirmDate=" + confirmDate +
                ", pubKeyInfo=" + pubKeyInfo +
                ", contractInfo=" + contractInfo +
                ", loginCodeInfo=" + loginCodeInfo +
                "} " + super.toString();
    }
}
