package com.wxbc.servicebean.cou;

import com.wxbc.common.validator.IsOverBatchLimit;
import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by administrator on 17-10-17.
 */
@Setter
@Getter
public class COUFinanceInfo extends PubKeyInfo {

    @IsOverBatchLimit
    private List<COUFinanceBean> lstCOUFinance;

    @NotNull
    private String fibln;
    private String warningBrief;
    private String warningSigned;  //verify

    @Override
    public String toString() {
        return "COUFinanceInfo{" +
                "lstCOUFinance=" + lstCOUFinance +
                ", fibln='" + fibln + '\'' +
                ", warningBrief='" + warningBrief + '\'' +
                ", warningSigned='" + warningSigned + '\'' +
                '}';
    }
}
