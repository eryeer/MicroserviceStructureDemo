package com.wxbc.servicebean.iv;

import com.wxbc.servicebean.cou.COUPay;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by administrator on 17-9-26.
 */
@Getter
@Setter
public class IVPayInfo extends IVCommitInfo {
    private List<COUPay> couPay;
    private String fibln;

    private String onProcessBrief;
    private String onProcessSigned;
    private BCOSCOUPayInfo onProcessInfo;

    @Override
    public String toString() {
        return "IVPayInfo{" +
                "couPay=" + couPay +
                ", fibln='" + fibln + '\'' +
                ", onProcessBrief='" + onProcessBrief + '\'' +
                ", onProcessSigned='" + onProcessSigned + '\'' +
                ", onProcessInfo=" + onProcessInfo +
                '}';
    }
}
