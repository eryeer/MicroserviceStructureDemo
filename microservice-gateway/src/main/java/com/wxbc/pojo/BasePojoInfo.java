package com.wxbc.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BasePojoInfo {
    private Integer id = -1;
    private String status;
    private String desc;
    private Date updateDate;
    private Date createDate;
    private String token;

    @Override
    public String toString() {
        return "BasePojoInfo{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", desc='" + desc + '\'' +
                ", updateDate=" + updateDate +
                ", createDate=" + createDate +
                ", token='" + token + '\'' +
                '}';
    }
}
