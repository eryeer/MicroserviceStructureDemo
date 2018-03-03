package com.wxbc.servicebean.iv;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by administrator on 17-9-20.
 */
@Getter
@Setter
public class IVBaseInfo extends PubKeyInfo {

    public static String OPER_TYPE_ADD = "addIV";
    public static String OPER_TYPE_UPDATE = "updateIV";
    @NotBlank
    private String ivBrief;
    @NotBlank
    private String ivSigned; //verify
    @NotBlank
    private String ivAddress;

    private String warningBrief;
    private String warningSigned;  //verify
    private String ivOperateType;

    private String contractID;

    public IVBaseInfo(IVBaseInfo base) {
        this.ivAddress = (base.ivAddress);
        this.ivBrief = (base.ivBrief);
        this.ivSigned = (base.ivSigned);
        this.warningBrief = (base.warningBrief);
        this.warningSigned = (base.warningSigned);
        this.contractID = (base.contractID);
    }

    public IVBaseInfo() {

    }

    @Override
    public String toString() {
        return "IVBaseInfo{" +
                "ivBrief='" + ivBrief + '\'' +
                ", ivSigned='" + ivSigned + '\'' +
                ", ivAddress='" + ivAddress + '\'' +
                ", warningBrief='" + warningBrief + '\'' +
                ", warningSigned='" + warningSigned + '\'' +
                ", ivOperateType='" + ivOperateType + '\'' +
                ", contractID='" + contractID + '\'' +
                '}';
    }
}
