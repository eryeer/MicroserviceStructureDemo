package com.wxbc.common;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by administrator on 17-8-31.
 */
public class AppPropReader {
    private static Properties props;

    static {
        try {
            Resource resource = new ClassPathResource("/application.properties");
            props = PropertiesLoaderUtils.loadProperties(resource);

        } catch (IOException e) {

        }
    }

    public static String getProperty(String key) {
        return props == null ? null : props.getProperty(key);
    }

    public static String getRestUrl() {
        return getProperty("spring.sp.baseURL") + "rest/";
    }

    public static String getMiddleRestUrl() {
        return getProperty("spring.sp.middleURL") + "rest/";
    }

    public static String getBaseUrl() {
        return getProperty("spring.sp.baseURL");
    }

    public static String getEmailHost() {
        return getProperty("email_smtp_host");
    }

    public static String getEmailUserName() {
        return getProperty("email_user_name");
    }

    public static String getEmailPw() {
        return getProperty("email_user_pw");
    }

    public static String getEmailProtocal() {
        return getProperty("email.Protocal");
    }

    public static String getEmailAuth() {
        return getProperty("email.Auth");
    }

    public static String getEmailPort() {
        return getProperty("email.Port");
    }

    public static int getSmsAppId() {
        return Integer.parseInt(getProperty("sms_app_id"));
    }

    public static String getSmsAppKey() {
        return getProperty("sms_app_key");
    }

    public static String getCompanyListFilePath() {
        return getProperty("company_list.filepath");
    }

    public static String getTLAccessToken() {
        return getProperty("tonglian.access_token");
    }

    public static String getTLUrl(){
        return getProperty("tonglian.url");
    }



    public static int getHttpMaxTotal() {
        return Integer.parseInt(getProperty("http.pool.maxtotal"));
    }

    public static int getEvictorWaitTime() {
        return Integer.parseInt(getProperty("http.evictor.waitTime"));
    }


    public static int getHttpDefultMaxPerRoute() {
        return Integer.parseInt(getProperty("http.pool.defaultMaxPerRoute"));
    }

    public static int getConnectionRequestTimeout() {
        return Integer.parseInt(getProperty("http.request.connectionRequestTimeout"));
    }

    public static int getConnectTimeout() {
        return Integer.parseInt(getProperty("http.request.connectTimeout"));
    }

    public static int getSocketTimeout() {
        return Integer.parseInt(getProperty("http.request.socketTimeout"));
    }

    public static boolean getStaleConnectionCheckEnabled() {
        return Boolean.parseBoolean(getProperty("http.request.staleConnectionCheckEnabled"));
    }


    public static boolean isDebug() {
        String isDebug = getProperty("isDebug");
        if (isDebug == null) {
            return false;
        } else {
            return "true".equals(isDebug);
        }

    }
}
