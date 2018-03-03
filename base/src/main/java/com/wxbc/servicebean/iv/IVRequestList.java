package com.wxbc.servicebean.iv;

import com.wxbc.common.validator.IsOverBatchLimit;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class IVRequestList<T>{
    @IsOverBatchLimit
    private List<T> invoices;

    @Override
    public String toString() {
        return "IVRequestList{" +
                "invoices=" + invoices +
                '}';
    }
}