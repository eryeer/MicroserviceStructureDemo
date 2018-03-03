package com.wxbc.servicebean.iv;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Author: Zhaochen
 * @Description:
 * @Date: created in 下午4:08 17-11-23
 */
@Setter
@Getter
public class ApplyIVPayInfo extends IVBaseInfo {

    @NotBlank
    private String encryptIVSelf;
    private String encryptIVTo;
    @NotBlank
    private String pubKeySignedSelf;
    private String pubKeySignedTo;

    @NotBlank
    private String roleSelf;
    private String roleTo;

    private String fibln;
    private long ivpayed;

    @Override
    public String toString() {
        return "ApplyIVPayInfo{" +
                " pubKeySignedSelf='" + pubKeySignedSelf + '\'' +
                ", pubKeySignedTo='" + pubKeySignedTo + '\'' +
                ", roleSelf='" + roleSelf + '\'' +
                ", roleTo='" + roleTo + '\'' +
                ", fibln='" + fibln + '\'' +
                ", ivpayed='" + ivpayed + '\'' +
                "} " + super.toString();
    }
}