package com.wxbc.servicebean.manager;

import com.wxbc.common.CommonConst;
import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by administrator on 17-8-29.
 */
@Getter
@Setter
public class UserKeyInfo extends PubKeyInfo {

    @NotBlank
    @Pattern(regexp = CommonConst.TEL_REGEX)
    private String phoneNum;
    private String pubKey;
    @Pattern(regexp = CommonConst.TAG_REGEX)
    private String tag;
    private String role1;
    private String role2;


    private List<String> roleList;
    private String businessLicenseNum;
    private int companyId;
    private int isRegConfirmed;

    public List<String> getRoleList() {

        if (StringUtils.isEmpty(role1)) {
            return this.roleList;
        }

        List<String> tmpRoleList = new ArrayList<>();
        if (!StringUtils.isEmpty(role1)) {
            tmpRoleList.add(role1);
        }
        if (!StringUtils.isEmpty(role2)) {
            tmpRoleList.add(role2);
        }
        return tmpRoleList;
    }

    @Override
    public String toString() {
        return "UserKeyInfo{" +
                "phoneNum='" + phoneNum + '\'' +
                ", pubKey='" + pubKey + '\'' +
                ", tag='" + tag + '\'' +
                ", role1='" + role1 + '\'' +
                ", role2='" + role2 + '\'' +
                ", businessLicenseNum='" + businessLicenseNum + '\'' +
                ", companyId=" + companyId +
                ", isRegConfirmed=" + isRegConfirmed +
                '}';
    }
}
