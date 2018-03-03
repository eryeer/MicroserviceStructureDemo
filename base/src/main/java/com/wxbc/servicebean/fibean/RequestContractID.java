package com.wxbc.servicebean.fibean;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by administrator on 17-9-29.
 */
@Getter
@Setter
public class RequestContractID extends PubKeyInfo {
    @NotBlank
    private String contractID;

    @Override
    public String toString() {
        return "RequestContractID{" +
                "contractID='" + contractID + '\'' +
                '}';
    }
}
