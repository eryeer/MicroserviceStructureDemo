package com.wxbc.servicebean.fibean;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @Author: ZhengJiao
 * @Description:
 * @Date: created in 上午11:01 17-12-11
 */
@Setter
@Getter
public class RequestDRFinalValueInfo extends PubKeyInfo {
    @NotBlank
    private String snbln;
    @NotNull
    private Long drFinalValue;
    @NotBlank
    private String drFinalValueSigned;

    @Override
    public String toString() {
        return "RequestDRShiftRangeInfo{" +
                "snbln='" + snbln + '\'' +
                ", drFinalValue=" + drFinalValue +
                ", drFinalValueSigned='" + drFinalValueSigned + '\'' +
                "} " + super.toString();
    }
}