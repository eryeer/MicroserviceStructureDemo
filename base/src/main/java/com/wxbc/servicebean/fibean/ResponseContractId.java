package com.wxbc.servicebean.fibean;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-9-29.
 */
@Getter
@Setter
public class ResponseContractId extends ResponseBase {
    private int fileID;
    private String fileName;
    public ResponseContractId(){
        this.setReturnCode(ResponseBase.returnCode_200);
    }

    @Override
    public String toString() {
        return "ResponseContractId{" +
                "fileID=" + fileID +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
