package com.wxbc.servicebean;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-9-22.
 */
@Getter
@Setter
public class QueryRest extends PubKeyInfo {
    private QueryCondition condition;

    @Override
    public String toString() {
        return "QueryRest{" +
                "condition=" + condition +
                '}';
    }
}
