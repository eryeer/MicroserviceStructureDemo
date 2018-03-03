package com.wxbc.servicebean.dr;

import com.wxbc.common.BaseInfo;
import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by administrator on 17-10-13.
 */
@Setter
@Getter
public class RequestCompanyDR extends BaseInfo {

    private List<CompanyDR> listCompanyDR;

}
