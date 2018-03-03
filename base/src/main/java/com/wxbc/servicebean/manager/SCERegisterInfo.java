package com.wxbc.servicebean.manager;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-9-11.
 */
@Getter
@Setter
public class SCERegisterInfo {
    private String CRecPubKey;
    private String FIRecPubKey;
    private String SPSnRecPubKey;

    @Override
    public String toString() {
        return "SCERegisterInfo{" +
                "CRecPubKey='" + CRecPubKey + '\'' +
                ", FIRecPubKey='" + FIRecPubKey + '\'' +
                ", SPSnRecPubKey='" + SPSnRecPubKey + '\'' +
                '}';
    }
}
