package com.wxbc.controller;

import com.wxbc.common.CommonConst;
import com.wxbc.common.ResponseFormat;
import com.wxbc.common.ReturnCode;
import com.wxbc.exception.HystrixFallBackException;
import com.wxbc.pojo.BasePojoInfo;
import com.wxbc.pojo.IVInfo;
import com.wxbc.service.IVService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/iv")
@CrossOrigin(origins = "*", maxAge = 3600)
public class IVController {
    @Autowired
    private IVService ivService;

    @ResponseBody
    @RequestMapping(value = "/getIV/{ivAddress}", produces = {CommonConst.PRODUCE}, method = RequestMethod.GET)
    public ResponseFormat getIV(@PathVariable("ivAddress") String ivAddress) {
        ResponseFormat response = new ResponseFormat(ReturnCode.READ_SUCCESS);
        try {
            IVInfo ivInfo = ivService.getIV(ivAddress);
            checkFallback(response, ivInfo);
            ArrayList<IVInfo> ivInfos = new ArrayList<>();
            ivInfos.add(ivInfo);
            response.setItems(ivInfos);
        } catch (Exception e) {
            response.setReturnCodeEx(ReturnCode.READ_FAILED);
            response.setReturnDesc(e.getMessage());
        }
        return response;
    }

    private void checkFallback(ResponseFormat response, Object obj) {
        if (obj instanceof BasePojoInfo) {
            BasePojoInfo info = (BasePojoInfo) obj;

            if (StringUtils.equals(info.getStatus(), CommonConst.HYSTRIX_FALLBACK_STATUS)) {
                response.setReturnCodeEx(ReturnCode.HYSTRIX_FALLBACK);
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            if (list != null) {
                Object o = list.get(0);
                if (o != null && o instanceof BasePojoInfo) {
                    BasePojoInfo info = (BasePojoInfo) o;
                    if (StringUtils.equals(info.getStatus(), CommonConst.HYSTRIX_FALLBACK_STATUS)) {
                        response.setReturnCodeEx(ReturnCode.HYSTRIX_FALLBACK);
                    }
                }
            }
        }

    }
}
