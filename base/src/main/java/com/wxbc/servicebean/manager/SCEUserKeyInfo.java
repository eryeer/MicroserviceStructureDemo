package com.wxbc.servicebean.manager;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-9-11.
 */
@Getter
@Setter

public class SCEUserKeyInfo extends UserKeyInfo {
    private String enc;

    @Override
    public String toString() {
        return "SCEUserKeyInfo{" +
                "enc='" + enc + '\'' +
                '}';
    }
}
