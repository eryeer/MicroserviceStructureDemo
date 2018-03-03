package com.wxbc.servicebean.cou;

import com.alibaba.fastjson.annotation.JSONField;
import com.wxbc.common.BaseInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by administrator on 17-11-13.
 */
@Getter
@Setter
public class DFCAgreementInfo extends BaseInfo {

    private String dfcAgreement;
    private String dfcAgreementHtml;
    private Date snTime;
    private String snBrief;
    private String snSigned;
    private Date cTime;
    private String cBrief;
    private String cSigned;
    private Date fiTime;
    private String fiBrief;
    private String fiSigned;

    @Override
    public String toString() {
        return "DFCAgreementInfo{" +
                "snTime=" + snTime +
                ", snBrief='" + snBrief + '\'' +
                ", snSigned='" + snSigned + '\'' +
                ", cTime=" + cTime +
                ", cBrief='" + cBrief + '\'' +
                ", cSigned='" + cSigned + '\'' +
                ", fiTime=" + fiTime +
                ", fiBrief='" + fiBrief + '\'' +
                ", fiSigned='" + fiSigned + '\'' +
                '}';
    }
}
