package com.wxbc.servicebean.dr;

import com.wxbc.common.BaseInfo;
import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by administrator on 17-10-11.
 */
@Getter
@Setter
public class DRDegreeList extends BaseInfo {

    private List<DRDegreeInfo> lstDRDegree;

    @Override
    public String toString() {
        return "DRDegreeList{" +
                "lstDRDegree=" + lstDRDegree +
                '}';
    }
}
