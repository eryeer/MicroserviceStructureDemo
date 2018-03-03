package com.wxbc.servicebean.contract;

import com.wxbc.common.CommonConst;
import com.wxbc.servicebean.PubKeyInfo;
import com.wxbc.servicebean.manager.FileInfo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by administrator on 17-9-12.
 */
@Getter
@Setter
public class ContractInfo extends PubKeyInfo {
    @Pattern(regexp = CommonConst.CONTRACT_NAME_REGEX)
    String contractName;      //《购销合同》名称
    String fromSCEBusinessLicenseNum;
    String toSCEBusinessLicenseNum;
    String toSCEName;         //《购销合同》的交易对方
    @Length(max=60)
    String contractID;        //《购销合同》编号
    Date contractStartDate; //《购销合同》起始日
    Date contractEndDate;   //《购销合同》结束日
    String contractFileID;    //《购销合同》在BCOS上的fileID

    FileInfo fileInfo;

    public String toString(){
        StringBuffer sb =new StringBuffer();
        sb.append("contractName:").append(contractName);
        sb.append("fromSCEBusinessLicenseNum:").append(fromSCEBusinessLicenseNum);
        sb.append("toSCEBusinessLicenseNum:").append(toSCEBusinessLicenseNum);
        sb.append("toSCEName:").append(toSCEName);
        sb.append("contractID:").append(contractID);
        sb.append("contractStartDate:").append(contractStartDate);
        sb.append("contractEndDate:").append(contractEndDate);
        sb.append("contractFileID:").append(contractFileID);
        return  sb.toString();
    }

}