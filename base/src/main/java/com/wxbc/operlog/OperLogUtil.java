package com.wxbc.operlog;

import com.alibaba.fastjson.JSON;
import com.wxbc.operlog.bean.OperLogInfo;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * Created by administrator on 17-9-4.
 */
public class OperLogUtil {

    protected static Logger logger = LoggerFactory.getLogger("OperLogUtil");

    public static OperLogInfo getOperLog(HttpServletRequest request, JoinPoint joinPoint, String type, Date beginTime, String loginUser){

        String title = "";
        OperLogAnnotation operLogAnnotation =   getOperLogAnnotation(joinPoint);
        try {
            title = operLogAnnotation.description();
        } catch (Exception e) {
            logger.warn("get request description exception",e.getMessage());
            e.printStackTrace();
        }
        String methodName = joinPoint.getSignature().getName();
        //如果上传文件，则不记录入参
        if (StringUtils.equals(methodName,"uploadContract")||StringUtils.equals(methodName,"handleFileUpload")){
            return getOperLogBase(request,title, "uploadFile",type,beginTime,loginUser);
        }

        return   getOperLogBase(request,title, Arrays.toString(joinPoint.getArgs()),type,beginTime,loginUser);

    }

    public static OperLogInfo getOperLogBase(HttpServletRequest request,String title,String parameter, String type,Date beginTime,String loginUser){
        String remoteAddr = request.getRemoteAddr();//请求的IP
        String requestUri = request.getRequestURI();//请求的Uri
        String method = request.getMethod();        //请求的方法类型(post/get)
        long endTime = System.currentTimeMillis();
        OperLogInfo log = new OperLogInfo();
        log.setLogId(UUID.randomUUID().toString());
        log.setTitle(title);
        log.setOpertype(type);
        log.setRemoteAddr(remoteAddr);
        log.setRequestUri(requestUri);
        log.setMethod(method);
        log.setParams(parameter);
        log.setPubKeySigned(loginUser);
        Date operateDate = beginTime;
        log.setCreateDate(operateDate);
        log.setUpdateDate(new Date(endTime));

        return log;
    }



    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return description
     */
    private static OperLogAnnotation getOperLogAnnotation(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        return method.getAnnotation(OperLogAnnotation.class);
    }


}
