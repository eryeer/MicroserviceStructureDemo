package com.wxbc.servicebean.cou;

import com.wxbc.common.validator.IsOverBatchLimit;
import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by administrator on 17-10-10.
 */
@Getter
@Setter
public class COUAcceptInfo extends PubKeyInfo {
    @IsOverBatchLimit
    private List<COUAcceptBean> lstCOUAccept;

    @Override
    public String toString() {
        return "COUAcceptInfo{" +
                "lstCOUAccept=" + lstCOUAccept +
                '}';
    }
}
