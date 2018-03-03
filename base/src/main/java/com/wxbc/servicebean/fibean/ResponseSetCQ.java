package com.wxbc.servicebean.fibean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-9-29.
 */
public class ResponseSetCQ extends ResponseBase {
    @JsonProperty(value = "COUTOTAL")
    private  long COUTOTAL;
    @JsonProperty(value = "CQAMOUNT")
    private long CQAMOUNT;

    public ResponseSetCQ(){
        this.setReturnCode(returnCode_200);
    }


    @JsonIgnore
    public long getCOUTOTAL() {
        return COUTOTAL;
    }
    @JsonIgnore
    public void setCOUTOTAL(long COUTOTAL) {
        this.COUTOTAL = COUTOTAL;
    }
    @JsonIgnore
    public long getCQAMOUNT() {
        return CQAMOUNT;
    }
    @JsonIgnore
    public void setCQAMOUNT(long CQAMOUNT) {
        this.CQAMOUNT = CQAMOUNT;
    }

    @Override
    public String toString() {
        return "ResponseSetCQ{" +
                "COUTOTAL=" + COUTOTAL +
                ", CQAMOUNT=" + CQAMOUNT +
                '}';
    }
}
