package com.wxbc.servicebean.cou;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

/**
 * Created by administrator on 17-9-26.
 */
@Getter
@Setter
public class COUTableInfo extends PubKeyInfo {

    String pubKeySigned;
    String couAddress;
    String encryptCOU;

    String couBrief;
    String couSigned;
    long amount;
    long dfcAmount;
    String remark;

    String warningBrief;
    String warningSigned;
    String role;
    String pubKeySignedSrc;
    Integer index;

    int protocolFileId;

    DFCAgreementInfo dfcAgreementInfo ;


    public void setCOUBaseInfo(COUPay baseInfo) {
        this.amount = baseInfo.getAmount();
        this.couAddress = baseInfo.getCouAddress();
        this.couBrief = baseInfo.getCouBrief();
        this.couSigned = baseInfo.getCouSigned();
    }


    public void setTableInfo(String encryptCOUSelf, String pubKeySignedSelf, String statusOnprocess) {
        this.encryptCOU = encryptCOUSelf;
        this.pubKeySigned = pubKeySignedSelf;
        this.setStatus(statusOnprocess);
    }

    public static class COUTableCompareByUpdateDate implements Comparator<COUTableInfo> {

        @Override
        public int compare(COUTableInfo cou1, COUTableInfo cou2) {
            if(cou1.getUpdateDate().after(cou2.getUpdateDate())){
                return -1;
            }
            else if(cou1.getUpdateDate().before(cou2.getUpdateDate())){
                return 1;
            }
            else return 0;

        }
    }

    @Override
    public String toString() {
        return "COUTableInfo{" +
                "pubKeySigned='" + pubKeySigned + '\'' +
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
