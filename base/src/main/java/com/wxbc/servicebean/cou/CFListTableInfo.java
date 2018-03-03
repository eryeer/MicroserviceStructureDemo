package com.wxbc.servicebean.cou;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Zhaochen
 * @Description:
 * @Date: created in 下午7:10 17-11-29
 */
@Setter
@Getter
public class CFListTableInfo extends PubKeyInfo {

    private String ivAddress;
    private long amount;

    public CFListTableInfo(String pubKeySigned, String ivAddress, long amount) {
        this.ivAddress = ivAddress;
        this.amount = amount;
        super.setPubKeySigned(pubKeySigned);
    }

    @Override
    public String toString() {
        return "CFListTableInfo{" +
                "ivAddress='" + ivAddress + '\'' +
                ", amount=" + amount +
                "} " + super.toString();
    }
}