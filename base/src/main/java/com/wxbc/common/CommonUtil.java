package com.wxbc.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wxbc.common.httpclient.HttpClient;
import com.wxbc.exception.InvalidAccessException;
import com.wxbc.servicebean.manager.UserKeyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by administrator on 17-9-4.
 */
public class CommonUtil {
    protected static Logger logger = LoggerFactory.getLogger("CommonUtil");

    public static boolean checkPhoneNum(String phoneNum){
        return Pattern.matches(CommonConst.TEL_REGEX,phoneNum);
    }

    public static String readFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            logger.error("Can not find file: " + path);
            throw new IOException("Can not find file: " + path);
        }
        StringBuffer sb = new StringBuffer();
        String s = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((s = br.readLine()) != null) {
            sb.append(s).append(" ");
        }
        return sb.toString();
    }

    public static Map getRequestParam(HttpServletRequest request) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map values = mapper.readValue(request.getReader(), Map.class);

        return values;

    }

    public static String getIPFromURL(String url){
        Pattern pattern =Pattern.compile(CommonConst.IP_REGEX);
        Matcher matcher =pattern.matcher(url);
        if(matcher.find()){
            return matcher.group(0);
        }
        return "";
    }




    public static ResponseFormat pareResponseFromStr(String responseBody) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, ResponseFormat.class);
    }

    public static ResponseFormatWithPubKeyIndex pareResponseFromStrWithPubKeyIndex(String responseBody) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseBody, ResponseFormatWithPubKeyIndex.class);
    }

    public static UserKeyInfo getUserKeyInfo(String signed) throws Exception {
        logger.info("pubKeySigned=" +signed);
        String url = AppPropReader.getRestUrl() + CommonConst.GetUserKeyWithSigned + URLEncoder.encode(signed,"UTF-8");
        String responseBody = HttpClient.sendGet(url);

        if (responseBody.isEmpty()) {
            logger.error("public Key Signed不存在.");
            throw new InvalidAccessException(CommonConst.INVALID_ACCESS);
        }
        ObjectMapper mapper = new ObjectMapper();
        UserKeyInfo keyInfo = mapper.readValue(responseBody, UserKeyInfo.class);
        return keyInfo;
    }

    public static String Bean2String(Object info) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonBody = mapper.writeValueAsString(info);
        return jsonBody;
    }

}
