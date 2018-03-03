package com.wxbc.servicebean.cou;

import com.wxbc.common.validator.IsOverBatchLimit;
import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by administrator on 17-10-20.
 */
@Setter
@Getter
public class CMDDoneInfo extends PubKeyInfo {
    @IsOverBatchLimit
    private List<CMDDoneBean> lstCMDDone;

    @Override
    public String toString() {
        return "CMDDoneInfo{" +
                "lstCMDDone=" + lstCMDDone +
                '}';
    }
}
