package com.wxbc.servicebean.cou;

import com.wxbc.common.validator.IsOverBatchLimit;
import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by administrator on 17-10-19.
 */
@Getter
@Setter
public class CancelDFCInfo extends PubKeyInfo{

    @IsOverBatchLimit
    private List<CancelDFCBean>  cancelDFCs;

    @Override
    public String toString() {
        return "CancelDFCInfo{" +
                "cancelDFCs=" + cancelDFCs +
                '}';
    }
}