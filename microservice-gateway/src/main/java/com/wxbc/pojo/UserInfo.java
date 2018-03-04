package com.wxbc.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserInfo extends BasePojoInfo{
    private String name;
    private String password;
    private String role;
    private String tel;

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", tel='" + tel + '\'' +
                "} " + super.toString();
    }
}
