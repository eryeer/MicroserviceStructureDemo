package com.wxbc.servicebean.iv;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-10-25.
 */
@Setter
@Getter
public class IVTemp extends IVTableInfo {
    private String datasource;

    public IVTemp(){}

    public IVTemp(IVBaseInfo ivBase){
        super(ivBase);
    }

    public IVTemp(IVTableInfo ivTable){
        super(ivTable);
        this.setPubKeySigned(ivTable.getPubKeySigned());
        this.setEncryptIV(ivTable.getEncryptIV());
        this.setRole(ivTable.getRole());
        this.setStatus(ivTable.getStatus());
        this.setPubKeySignedSrc(ivTable.getPubKeySignedSrc());
    }

    @Override
    public String toString() {
        return "IVTemp{" +
                "datasource='" + datasource + '\'' +
                '}';
    }
}