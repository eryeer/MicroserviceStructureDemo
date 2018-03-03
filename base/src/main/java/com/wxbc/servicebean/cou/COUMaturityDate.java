package com.wxbc.servicebean.cou;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class COUMaturityDate{

    private int id;

    private Date createDate;

    private Date updateDate;

    private int dueDay;

    @Override
    public String toString() {
        return "COUMaturityDate{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", dueDay=" + dueDay +
                '}';
    }
}