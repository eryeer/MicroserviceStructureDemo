package com.wxbc.servicebean.fibean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by administrator on 17-9-29.
 */
@Getter
@Setter
public class FIDRInfo {
    private int id;
    private long originalDR;
    private long newDR;
    private String snBusinessLicenseNumber;
    private String snName;

    private Date createDate;

    private String companyDRBrief;
    private String companyDRSigned;

    private String pubKeySignedC;

    @Override
    public String toString() {
        return "FIDRInfo{" +
                "id=" + id +
                ", originalDR=" + originalDR +
                ", newDR=" + newDR +
                ", snBusinessLicenseNumber='" + snBusinessLicenseNumber + '\'' +
                ", snName='" + snName + '\'' +
                ", createDate=" + createDate +
                ", companyDRBrief='" + companyDRBrief + '\'' +
                ", companyDRSigned='" + companyDRSigned + '\'' +
                ", pubKeySignedC='" + pubKeySignedC + '\'' +
                '}';
    }
}
