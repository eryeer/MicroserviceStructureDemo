package com.wxbc.servicebean.fibean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by administrator on 17-9-29.
 */
@Getter
@Setter
public class ResponseDR extends ResponseBase {
    private List<FIDRInfo> drList;
    public ResponseDR(){
        this.setReturnCode(ResponseBase.returnCode_200);
    }

    @Override
    public String toString() {
        return "ResponseDR{" +
                "drList=" + drList +
                '}';
    }
}
