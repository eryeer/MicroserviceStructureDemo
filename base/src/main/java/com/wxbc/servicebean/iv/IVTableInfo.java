package com.wxbc.servicebean.iv;

import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;

/**
 * Created by administrator on 17-9-22.
 */
@Setter
@Getter
public class IVTableInfo extends  IVBaseInfo{

    String encryptIV;
    String pubKeySigned;
    String role;
    String pubKeySignedSrc;
    Integer index;

    public IVTableInfo(){

    }

    public IVTableInfo(IVBaseInfo base){
        super(base);
    }

    public void setTableInfo(String encryptIV,String pubKeySigned,String role){
        this.role=role;
        this.encryptIV =encryptIV;
        this.pubKeySigned=pubKeySigned;
    }

    public void setTableInfo(String encryptIV,String pubKeySigned,String role,String pubKeySignedSrc){
        this.role=role;
        this.encryptIV =encryptIV;
        this.pubKeySigned=pubKeySigned;
        this.pubKeySignedSrc = pubKeySignedSrc;
    }

    public static class IVTableCompareByUpdateDate implements Comparator<IVTableInfo>{

        @Override
        public int compare(IVTableInfo iv1, IVTableInfo iv2) {
            if(iv1.getUpdateDate().after(iv2.getUpdateDate())){
                return -1;
            }
            else if(iv1.getUpdateDate().before(iv2.getUpdateDate())){
                return 1;
            }
            else return 0;

        }
    }

    @Override
    public String toString() {
        return "IVTableInfo{" +
                "encryptIV='" + encryptIV + '\'' +
                ", pubKeySigned='" + pubKeySigned + '\'' +
                ", role='" + role + '\'' +
                ", pubKeySignedSrc='" + pubKeySignedSrc + '\'' +
                ", index=" + index +
                '}';
    }
}


