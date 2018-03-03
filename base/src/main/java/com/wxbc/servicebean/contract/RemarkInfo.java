package com.wxbc.servicebean.contract;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

/**
 * Created by administrator on 17-9-11.
 */
@Getter
@Setter
public class RemarkInfo extends PubKeyInfo {

    @Size(max = 200, min = 1)
    private String remark;

    private String status="";

    private String companyInfoBrief;
    private String companyInfoSigned;

    @Override
    public String toString() {
        return "RemarkInfo{" +
                "remark='" + remark + '\'' +
                ", status='" + status + '\'' +
                ", companyInfoBrief='" + companyInfoBrief + '\'' +
                ", companyInfoSigned='" + companyInfoSigned + '\'' +
                '}';
    }
}
