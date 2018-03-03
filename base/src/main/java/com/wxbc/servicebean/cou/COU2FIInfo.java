package com.wxbc.servicebean.cou;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by administrator on 17-10-19.
 */
@Getter
@Setter
public class COU2FIInfo extends PubKeyInfo {
    private List<COU2FIBean> lstCOU2FI;
    private String fibln;

    @Override
    public String toString() {
        return "COU2FIInfo{" +
                "lstCOU2FI=" + lstCOU2FI +
                ", fibln='" + fibln + '\'' +
                '}';
    }
}
