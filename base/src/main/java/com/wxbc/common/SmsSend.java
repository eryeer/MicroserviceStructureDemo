package com.wxbc.common;


import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

import java.util.ArrayList;

/**

 */
public class SmsSend {

    //appid,appkey,templId申请方式可参考接入指南 https://www.qcloud.com/document/product/382/3785#5-.E7.9F.AD.E4.BF
    // .A1.E5.86.85.E5.AE.B9.E9.85.8D.E7.BD.AE
    static final int appid = AppPropReader.getSmsAppId();
    static final String appkey = AppPropReader.getSmsAppKey();
    static final String signName = "";//默认签名为"万向区块链"，需系统配置，此处若填值与默认不一致，将作为副签名

    public static SmsSingleSenderResult sendCode(String phoneNumber, ArrayList<String> smsParams,  int tmplId)
            throws Exception {
        //初始化单发
        SmsSingleSender singleSender = new SmsSingleSender(appid, appkey);
        SmsSingleSenderResult singleSenderResult;

        //指定模板单发
        singleSenderResult = singleSender.sendWithParam("86", phoneNumber, tmplId, smsParams, signName, "", "");

        return singleSenderResult;
    }
}
