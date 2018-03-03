package com.wxbc.servicebean.fibean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-9-29.
 */
@Getter
@Setter
public class FinApplyInfo {
    @JsonProperty(value = "cBusinessLicenseNumber")
    private String cBusinessLicenseNumber;

    private String couAddress;
    private String snBusinessLicenseNumber;
    private String snName;
    private String encryptCOU;
    private String pubKeySignedC;

    public String getcBusinessLicenseNumber() {
        return cBusinessLicenseNumber;
    }

    public void setcBusinessLicenseNumber(String cBusinessLicenseNumber) {
        this.cBusinessLicenseNumber = cBusinessLicenseNumber;
    }

    @Override
    public String toString() {
        return "FinApplyInfo{" +
                "cBusinessLicenseNumber='" + cBusinessLicenseNumber + '\'' +
                ", couAddress='" + couAddress + '\'' +
                ", snBusinessLicenseNumber='" + snBusinessLicenseNumber + '\'' +
                ", snName='" + snName + '\'' +
                ", encryptCOU='" + encryptCOU + '\'' +
                ", pubKeySignedC='" + pubKeySignedC + '\'' +
                '}';
    }
}
