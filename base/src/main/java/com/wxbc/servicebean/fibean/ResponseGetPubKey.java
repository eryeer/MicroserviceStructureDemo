package com.wxbc.servicebean.fibean;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-10-18.
 */
@Getter
@Setter
public class ResponseGetPubKey extends ResponseBase {
    private String pubKey;
    public ResponseGetPubKey(){
        this.setReturnCode(returnCode_200);
    }

    @Override
    public String toString() {
        return "ResponseGetPubKey{" +
                "pubKey='" + pubKey + '\'' +
                '}';
    }
}
