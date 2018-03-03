package com.wxbc.servicebean;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by administrator on 17-9-18.
 */
@Getter
@Setter
public class QueryCondition  extends TimeCondition{

    @NotBlank
    private String pubKeySigned;

    @Override
    public String toString() {
        return "QueryCondition{" +
                "pubKeySigned='" + pubKeySigned + '\'' +
                '}';
    }
}
