package com.wxbc.servicebean.dr;

import com.wxbc.common.BaseInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-10-10.
 */
@Getter
@Setter
public class DRDegreeInfo extends BaseInfo {

    public static String STATUS_ADD="add";
    public static String STATUS_MOD="modify";
    public static String STATUS_DEL="delete";


    private int degree;
    private int degreeValue;
    private int degreeShift;

    private String drDegreeBrief;
    private String drDegreeSigned;


    public String toString() {
        return String.valueOf(degree);
    }

    @Override

    public int hashCode() {
        return degree;
    }

    @Override
    public boolean equals(Object dr) {
        if (this == dr) {
            return true;
        }
        if (dr == null) {
            return false;
        }

        if (dr.getClass() != this.getClass()) {
            return false;
        }
        final DRDegreeInfo drDegreeInfo = (DRDegreeInfo) dr;
        if ((drDegreeInfo.degree == this.degree )  &&(drDegreeInfo.degreeValue ==this.degreeValue )
                &&(drDegreeInfo.degreeShift ==this.degreeShift)) {
            return true;
        }

        return false;
    }
}
