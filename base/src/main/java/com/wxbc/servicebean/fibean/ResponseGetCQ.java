package com.wxbc.servicebean.fibean;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-9-29.
 */
@Getter
@Setter
public class ResponseGetCQ extends ResponseBase {
    private long CQ;
    public ResponseGetCQ(){
        this.setReturnCode(ResponseBase.returnCode_200);
    }

    @Override
    public String toString() {
        return "ResponseGetCQ{" +
                "CQ=" + CQ +
                '}';
    }
}
