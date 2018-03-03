package com.wxbc.rolemanager.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by administrator on 17-9-26.
 */
@Getter
@Setter
public class RoleResponse<T> {
    private List<String > roleList;
    private T companyInfo;

    @Override
    public String toString() {
        return "RoleResponse{" +
                ", companyInfo=" + companyInfo +
                '}';
    }
}
