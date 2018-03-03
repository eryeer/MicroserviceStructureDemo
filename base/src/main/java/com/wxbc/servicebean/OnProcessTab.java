package com.wxbc.servicebean;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-11-14.
 */
@Setter
@Getter
public class OnProcessTab{
    private int id;
    private String status;
    private String callingAPI;
    private String data;

    @Override
    public String toString() {
        return "OnProcessTab{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", callingAPI='" + callingAPI + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}