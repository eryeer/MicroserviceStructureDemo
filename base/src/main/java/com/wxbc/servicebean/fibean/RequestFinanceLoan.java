package com.wxbc.servicebean.fibean;

import com.wxbc.servicebean.PubKeyInfo;
import com.wxbc.servicebean.cou.DFCAgreementInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by administrator on 17-9-29.
 */
@Getter
@Setter
public class RequestFinanceLoan extends PubKeyInfo {
    private String couAddress;
    private String snBusinessLicenseNumber;
    private String auditResult;
    private long amountDFC;
    private long amount;
    private Date auditDate;
    private String remark;

    private String makeLoanResultBrief;
    private String makeLoanResultSigned;

    private String couSigned;
    private String couBrief;
    private String encCOUInfoSn;
    private String encCOUInfoFI;

    private DFCAgreementInfo dfcAgreementInfo;


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(couAddress).append("    ");
        sb.append(auditResult).append("    ");
        sb.append(amountDFC).append("    ");
        sb.append(auditDate).append("    ");
        sb.append(remark).append("    ");
        sb.append(makeLoanResultBrief).append("    ");
        sb.append(makeLoanResultSigned).append("    ");
        sb.append(amount).append("    ");
        return sb.toString();

    }
}
