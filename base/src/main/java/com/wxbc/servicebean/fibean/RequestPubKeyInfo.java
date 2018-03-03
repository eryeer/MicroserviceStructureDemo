package com.wxbc.servicebean.fibean;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-10-26.
 */
@Setter
@Getter
public class RequestPubKeyInfo extends PubKeyInfo {

    private String pubKeySignedTarget;
    private String businessLicenseNum;

    @Override
    public String toString() {
        return "RequestPubKeyInfo{" +
                "pubKeySignedTarget='" + pubKeySignedTarget + '\'' +
                ", businessLicenseNum='" + businessLicenseNum + '\'' +
                '}';
    }
}
