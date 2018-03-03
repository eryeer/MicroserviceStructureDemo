package com.wxbc.servicebean.iv;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by administrator on 17-9-19.
 */
@Getter
@Setter
public class IVCommitInfo extends IVBaseInfo {
    @NotBlank
    private String encryptIVSelf;
    private String encryptIVTo;
    private String encryptIVCfm;
    private String encryptIVCa;
    @NotBlank
    private String pubKeySignedSelf;
    private String pubKeySignedTo;
    private String pubKeySignedCfm;
    private String pubKeySignedCa;

    @NotBlank
    private String roleSelf;
    private String roleTo;
    private String roleCfm;


    public IVCommitInfo() {}

    @Override
    public String toString() {
        return "IVCommitInfo{" +
                " pubKeySignedSelf='" + pubKeySignedSelf + '\'' +
                ", pubKeySignedTo='" + pubKeySignedTo + '\'' +
                ", pubKeySignedCfm='" + pubKeySignedCfm + '\'' +
                ", pubKeySignedCa='" + pubKeySignedCa + '\'' +
                ", roleSelf='" + roleSelf + '\'' +
                ", roleTo='" + roleTo + '\'' +
                ", roleCfm='" + roleCfm + '\'' +
                '}';
    }
}
