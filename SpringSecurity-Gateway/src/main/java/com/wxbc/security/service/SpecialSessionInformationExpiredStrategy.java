package com.wxbc.security.service;

import com.wxbc.util.CommonUtil;
import com.wxbc.util.ResponseFormat;
import com.wxbc.util.ReturnCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import java.io.IOException;

/**
 * Created by administrator on 17-10-25.
 */
public class SpecialSessionInformationExpiredStrategy implements SessionInformationExpiredStrategy {
    private final Log logger = LogFactory.getLog(getClass());
    private final ReturnCode returnCode;

    public SpecialSessionInformationExpiredStrategy(ReturnCode returnCode) {
        this.returnCode = returnCode;
    }


    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException {
        logger.debug("Send returnMessage : '" + returnCode.getValue() + " : " + returnCode.getDesc() + "'");
        ResponseFormat format =new ResponseFormat();
        format.setReturnCodeEx(returnCode);
        event.getResponse().setHeader("Content-type","text/html;charset=UTF-8");
        event.getResponse().setCharacterEncoding("UTF-8");
        event.getResponse().getWriter().write(CommonUtil.Bean2String(format));
        event.getResponse().getWriter().flush();
    }

}
