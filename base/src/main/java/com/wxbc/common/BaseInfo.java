package com.wxbc.common;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by administrator on 17-9-4.
 */
@Getter
@Setter
public class BaseInfo implements Serializable {

    private int id =-1;
    private Date updateDate;
    private Date createDate;
    private String status;

    private String token;
    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
