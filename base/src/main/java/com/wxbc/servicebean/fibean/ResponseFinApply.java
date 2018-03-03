package com.wxbc.servicebean.fibean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by administrator on 17-9-29.
 */
@Getter
@Setter
public class ResponseFinApply extends ResponseBase {
    private List<FinApplyInfo> couNoticeList;

    public ResponseFinApply() {
        this.setReturnCode(returnCode_200);
    }

    @Override
    public String toString() {
        return "ResponseFinApply{" +
                "couNoticeList=" + couNoticeList +
                '}';
    }
}
