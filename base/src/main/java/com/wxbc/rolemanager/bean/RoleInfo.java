package com.wxbc.rolemanager.bean;

import com.wxbc.common.BaseInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleInfo extends BaseInfo {
    public static final String ROLE_SPOperator = "ROLE_SPOperator";

    public static final String ROLE_CAuthorizer = "ROLE_CAuthorizer";
    public static final String ROLE_COperator = "ROLE_COperator";
    public static final String ROLE_CFManager = "ROLE_CFManager";
    public static final String ROLE_FIRole = "ROLE_FIRole";
    public static final String ROLE_SnAuthorizer = "ROLE_SnAuthorizer";
    public static final String ROLE_SnOperator = "ROLE_SnOperator";
    public static final String ROLE_R = "ROLE_RObserver";
    private String name;

    @Override
    public String toString() {
        return "RoleInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}
