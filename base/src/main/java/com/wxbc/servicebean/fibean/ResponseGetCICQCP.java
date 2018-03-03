package com.wxbc.servicebean.fibean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by administrator on 17-9-29.
 */
public class ResponseGetCICQCP extends ResponseBase {
    @JsonProperty(value = "CQ")
    private long CQ;
    @JsonProperty(value = "CI")
    private long CI;
    @JsonProperty(value = "CP")
    private long CP;
    @JsonProperty(value = "CF")
    private long CF;

    public ResponseGetCICQCP() {
        this.setReturnCode(ResponseBase.returnCode_200);
    }

    @JsonIgnore
    public long getCQ() {
        return CQ;
    }

    @JsonIgnore
    public void setCQ(long CQ) {
        this.CQ = CQ;
    }

    @JsonIgnore
    public long getCI() {
        return CI;
    }

    @JsonIgnore
    public void setCI(long CI) {
        this.CI = CI;
    }

    @JsonIgnore
    public long getCP() {
        return CP;
    }

    @JsonIgnore
    public void setCP(long CP) {
        this.CP = CP;
    }

    @JsonIgnore
    public long getCF() {
        return CF;
    }

    @JsonIgnore
    public void setCF(long CF) {
        this.CF = CF;
    }

    @Override
    public String toString() {
        return "ResponseGetCICQCP{" +
                "CQ=" + CQ +
                ", CI=" + CI +
                ", CP=" + CP +
                ", CF=" + CF +
                '}';
    }
}
