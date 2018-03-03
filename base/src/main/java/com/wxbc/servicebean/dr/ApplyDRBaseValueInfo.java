package com.wxbc.servicebean.dr;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Author: Zhaochen
 * @Description:
 * @Date: created in 下午5:12 17-12-7
 */
@Setter
@Getter
public class ApplyDRBaseValueInfo extends PubKeyInfo{
    @NotBlank
    private String businessLicenseNumber;
    @NotBlank
    private String blnSigned;
    private String sceName;
    private String registTime;

    @Override
    public String toString() {
        return "ApplyDRBaseValueInfo{" +
                "businessLicenseNumber='" + businessLicenseNumber + '\'' +
                ", blnSigned='" + blnSigned + '\'' +
                ", sceName='" + sceName + '\'' +
                ", registTime='" + registTime + '\'' +
                "} " + super.toString();
    }
}