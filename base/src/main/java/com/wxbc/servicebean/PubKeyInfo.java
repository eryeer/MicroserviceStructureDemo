package com.wxbc.servicebean;

import com.wxbc.common.BaseInfo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by administrator on 17-9-13.
 */
@Getter
@Setter
public class PubKeyInfo extends BaseInfo {

    private String pubKeySigned;

    private String pubKeyBrief;

    @Override
    public String toString() {
        return "PubKeyInfo{" +
                "pubKeySigned='" + pubKeySigned + '\'' +
                ", pubKeyBrief='" + pubKeyBrief + '\'' +
                '}';
    }
}
