package com.wxbc.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserInfo {
    private Integer id;
    private String name;
    private String password;
    private String role1;
    private String role2;
    private String tel;

}
