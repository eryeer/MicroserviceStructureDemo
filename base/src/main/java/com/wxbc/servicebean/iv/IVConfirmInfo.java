package com.wxbc.servicebean.iv;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by administrator on 17-9-21.
 */
@Getter
@Setter
public class IVConfirmInfo extends IVCommitInfo {
    @NotBlank
    private String encryptIVFrom;
    @NotBlank
    private String pubKeySignedFrom;
    @NotBlank
    private String roleFrom;

    @Override
    public String toString() {
        return "IVConfirmInfo{" +
                "pubKeySignedFrom='" + pubKeySignedFrom + '\'' +
                ", roleFrom='" + roleFrom + '\'' +
                '}';
    }
}
