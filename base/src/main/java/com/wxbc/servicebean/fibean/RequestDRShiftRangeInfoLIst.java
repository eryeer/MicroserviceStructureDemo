package com.wxbc.servicebean.fibean;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @Author: ZhengJiao
 * @Description:
 * @Date: created in 上午11:01 17-12-11
 */
@Setter
@Getter
public class RequestDRShiftRangeInfoLIst {
    @Size(max = 30, min = 1)
    private List<RequestDRShiftRangeInfo> drShiftRangeInfos;

    @Override
    public String toString() {
        return "RequestDRShiftRangeInfoLIst{" +
                "drShiftRangeInfos=" + drShiftRangeInfos +
                "} " + super.toString();
    }
}