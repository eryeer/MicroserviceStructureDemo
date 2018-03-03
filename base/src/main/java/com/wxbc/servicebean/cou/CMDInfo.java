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
public class CMDInfo extends PubKeyInfo {
    @IsOverBatchLimit
    private List<CMDBean> cmdBeans;

    @Override
    public String toString() {
        return "CMDInfo{" +
                "cmdBeans=" + cmdBeans +
                '}';
    }
}