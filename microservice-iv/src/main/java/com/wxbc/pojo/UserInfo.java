package com.wxbc.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserInfo {
    private Integer id;
    private String name;
    private String password;
    private String role;
    private String tel;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
