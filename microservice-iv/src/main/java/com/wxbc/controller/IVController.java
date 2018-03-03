package com.wxbc.controller;

import com.wxbc.common.CommonConst;
import com.wxbc.common.ResponseFormat;
import com.wxbc.common.ReturnCode;
import com.wxbc.pojo.IVInfo;
import com.wxbc.service.IVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
        IVInfo ivInfo = ivService.getIV(ivAddress);
        ArrayList<IVInfo> ivInfos = new ArrayList<>();
        ivInfos.add(ivInfo);
        response.setItems(ivInfos);
        return response;
    }
}
