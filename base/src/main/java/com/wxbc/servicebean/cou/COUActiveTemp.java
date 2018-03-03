package com.wxbc.servicebean.cou;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-10-25.
 */
@Getter
@Setter
public class COUActiveTemp extends COUTableInfo{
    private String datasource;

    public COUActiveTemp(){}

    public COUActiveTemp(COUTableInfo couTable){
        this.setCouAddress(couTable.getCouAddress());
        this.setCouBrief(couTable.getCouBrief());
        this.setCouSigned(couTable.getCouSigned());
        this.setWarningSigned(couTable.getWarningSigned());
        this.setWarningBrief(couTable.getWarningBrief());

        this.setPubKeySigned(couTable.getPubKeySigned());
        this.setEncryptCOU(couTable.getEncryptCOU());

        this.setStatus(couTable.getStatus());
        this.setAmount(couTable.getAmount());
        this.setDfcAmount(couTable.getDfcAmount());
        this.setRemark(couTable.getRemark());
        this.setPubKeySignedSrc(couTable.getPubKeySignedSrc());
	this.setProtocolFileId(couTable.getProtocolFileId());
    }

    public void setCMDBaseInfo(CMDBean baseInfo) {
        this.couAddress = baseInfo.getCouAddress();
        this.couBrief = baseInfo.getCouCMDBrief();
        this.couSigned = baseInfo.getCouCMDSigned();
        this.amount = baseInfo.getAmount();
        this.dfcAmount = baseInfo.getCmdAmount();
        this.warningBrief = baseInfo.getWarningBrief();
        this.warningSigned = baseInfo.getWarningSigned();
    }

    @Override
    public String toString() {
        return "COUActiveTemp{" +
                "datasource='" + datasource + '\'' +
                ", pubKeySigned='" + pubKeySigned + '\'' +
                ", couAddress='" + couAddress + '\'' +
                ", couBrief='" + couBrief + '\'' +
                ", couSigned='" + couSigned + '\'' +
                ", amount=" + amount +
                ", dfcAmount=" + dfcAmount +
                ", remark='" + remark + '\'' +
                ", warningBrief='" + warningBrief + '\'' +
                ", warningSigned='" + warningSigned + '\'' +
                ", role='" + role + '\'' +
                ", pubKeySignedSrc='" + pubKeySignedSrc + '\'' +
                ", index=" + index +
                ", protocolFileId=" + protocolFileId +
                '}';
    }
}