package com.wxbc.servicebean.cou;

import com.wxbc.common.validator.IsOverBatchLimit;
import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * Created by administrator on 17-10-20.
 */
@Getter
@Setter
public class ApplyCMDInfo extends PubKeyInfo {
    @IsOverBatchLimit
    private List<ApplyCMDBean> applyCmdBeans;

    @Override
    public String toString() {
        return "ApplyCMDInfo{" +
                "applyCmdBeans=" + applyCmdBeans +
                '}';
    }
}