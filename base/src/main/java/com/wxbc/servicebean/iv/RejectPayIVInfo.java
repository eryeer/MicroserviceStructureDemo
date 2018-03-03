package com.wxbc.servicebean.iv;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class RejectPayIVInfo extends PubKeyInfo {
    @NotBlank
    private String ivAddress;
    @NotBlank
    private String ivBrief;
    @NotBlank
    private String ivSigned;
    private String encryptIVSelf;
    private String encryptIVTo;
    @NotBlank
    private String pubKeySignedSelf;
    @NotBlank
    private String pubKeySignedTo;
    @NotBlank
    private String roleSelf;
    @NotBlank
    private String roleTo;

    @Override
    public String toString() {
        return "RejectPayIVInfo{" +
                "ivAddress='" + ivAddress + '\'' +
                ", ivBrief='" + ivBrief + '\'' +
                ", ivSigned='" + ivSigned + '\'' +
                ", pubKeySignedSelf='" + pubKeySignedSelf + '\'' +
                ", pubKeySignedTo='" + pubKeySignedTo + '\'' +
                ", roleSelf='" + roleSelf + '\'' +
                ", roleTo='" + roleTo + '\'' +
                '}';
    }
}