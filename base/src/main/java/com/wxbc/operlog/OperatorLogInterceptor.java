package com.wxbc.operlog;

import com.wxbc.common.CommonUtil;
import com.wxbc.operlog.bean.OperLogInfo;
import com.wxbc.operlog.mapper.OperLogMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Aspect
@Component
public class OperatorLogInterceptor {



}
