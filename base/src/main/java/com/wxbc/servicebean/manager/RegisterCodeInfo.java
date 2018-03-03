package com.wxbc.servicebean.manager;

import com.wxbc.common.BaseInfo;
import com.wxbc.common.CommonConst;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * Created by administrator on 17-9-8.
 */
@Getter
@Setter
public class RegisterCodeInfo extends BaseInfo {

    @NotBlank
    @Pattern(regexp = CommonConst.TEL_REGEX)
    private String phoneNum;

    @Length(min = 18, max = 18)
    private String businessLicenseNum; //统一社会信用码

    @Override
    public String toString() {
        return "RegisterCodeInfo{" +
                "phoneNum='" + phoneNum + '\'' +
                ", businessLicenseNum='" + businessLicenseNum + '\'' +
                '}';
    }
}
