package com.wxbc.servicebean.cou;

import com.wxbc.servicebean.TimeCondition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BLNInfo extends TimeCondition{

    private String businessLicenseNum;

    @Override
    public String toString() {
        return "BLNInfo{" +
                "businessLicenseNum='" + businessLicenseNum + '\'' +
                "startTime='" + super.getStartTime() + '\'' +
                "endTime='" + super.getEndTime() +
                '}';
    }
}