package com.wxbc.servicebean.manager;

import com.wxbc.common.BaseInfo;
import com.wxbc.common.CommonConst;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * Created by administrator on 17-9-12.
 */
@Getter
@Setter
public class LoginCodeInfo extends BaseInfo {

    public static String TYPE_LOGIN = "login";
    public static String TYPE_REGISTER = "register";
    public static String STATUS_SENT = "sent";
    public static String STATUS_USED = "used";
    public static String STATUS_INVALID = "invalid";
    public static String STATUS_NA = "NA";
    @NotBlank
    @Pattern(regexp = CommonConst.TEL_REGEX)
    private String phoneNum;

    @Pattern(regexp = CommonConst.CODE_REGEX)
    private String code = CommonConst.SP_CODE;

    private String pubKeySigned;

    private String businessLicenseNum;

    private String type;

    @Override
    public String toString() {
        return "LoginCodeInfo{" +
                "phoneNum='" + phoneNum + '\'' +
                ", code='" + code + '\'' +
                ", pubKeySigned='" + pubKeySigned + '\'' +
                ", businessLicenseNum='" + businessLicenseNum + '\'' +
                ", type='" + type + '\'' +
                "} " + super.toString();
    }
}
