package com.wxbc.operlog.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fengxinhe on 2017/8/21.
 */
@Getter
@Setter
public class OperLogInfo implements Serializable {

    public  static  final String LOG_TYPE_INFO="info";
    public  static  final String LOG_TYPE_WARN="warn";
    public  static  final String LOG_TYPE_ERROR="error";

    private static final long serialVersionUID = 1L;

    private String logId;           //日志主键
    private String opertype =LOG_TYPE_INFO;            //日志类型
    private String title;           //日志标题
    private String details;
    private String remoteAddr;          //请求地址
    private String requestUri;          //URI
    private String method;          //请求方式
    private String params;          //提交参数
    private Date createDate;           //开始时间
    private Date updateDate;         //结束时间
    private String pubKeySigned;          //用户ID

    @Override
    public String toString() {
        return "OperLogInfo{" +
                "logId='" + logId + '\'' +
                ", opertype='" + opertype + '\'' +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", remoteAddr='" + remoteAddr + '\'' +
                ", requestUri='" + requestUri + '\'' +
                ", method='" + method + '\'' +
                ", params='" + params + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", pubKeySigned='" + pubKeySigned + '\'' +
                '}';
    }
}
