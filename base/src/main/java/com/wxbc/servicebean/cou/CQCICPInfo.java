package com.wxbc.servicebean.cou;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wxbc.common.CommonConst;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Created by administrator on 17-9-27.
 */
@Getter
@Setter
public class CQCICPInfo {
    private long cq;
    private long ci;
    private long cp;
    private long cf;

    public CQCICPInfo() {

    }

    public CQCICPInfo(String jsonStr) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map map = mapper.readValue(jsonStr, Map.class);
        this.setCi(Long.parseLong(map.get(CommonConst.CenterIssued).toString()));
        this.setCp(Long.parseLong(map.get(CommonConst.CenterPaid).toString()));
        this.setCq(Long.parseLong(map.get(CommonConst.CenterQuota).toString()));
    }

    @Override
    public String toString() {
        return "CQCICPInfo{" +
                "cq=" + cq +
                ", ci=" + ci +
                ", cp=" + cp +
                ", cf=" + cf +
                '}';
    }
}
