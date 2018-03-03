package com.wxbc.common.httpclient;

import com.wxbc.common.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@Service
public class HttpClient {
    protected static Logger logger = LoggerFactory.getLogger("HttpClient");

    @Autowired(required = false)
    private CloseableHttpClient client;

    private static HttpClient httpClient;

    @PostConstruct
    public void init() {
        httpClient = this;
    }

    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("TLSv1.2");

        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                                           String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                                           String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        sc.init(null, new TrustManager[]{trustManager}, null);
        return sc;
    }

    public static String sendPost(String url, Object object)
            throws IOException {
        String jsonBody = CommonUtil.Bean2String(object);
        logger.debug("sendPost:" + jsonBody);
        String ip = CommonUtil.getIPFromURL(url);

        if (StringUtils.isEmpty(ip)) {
            logger.error("could not get ip from url ,url =" + url);
            return "error";
        }
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(jsonBody, "utf-8");
        entity.setContentEncoding(new BasicHeader("Content-Type", "application/json"));
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.client.execute(httpPost);
        return getBody(httpPost, response);
    }

    public static String sendGet(String url)
            throws IOException {
        String ip = CommonUtil.getIPFromURL(url);

        if (StringUtils.isEmpty(ip)) {
            logger.error("could not get ip from url ,url =" + url);
            return "error";
        }
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Content-type", "application/json");
        CloseableHttpResponse response = httpClient.client.execute(httpGet);
        return getBody(httpGet, response);
    }

    private static String getBody(HttpRequestBase httpRequestBase, CloseableHttpResponse response) throws IOException {
        String body = "";
        try {
            if (response != null) {
                HttpEntity entity2 = response.getEntity();
                if (entity2 != null) {
                    body = EntityUtils.toString(entity2, "UTF-8");
                }
                EntityUtils.consume(entity2);
            }
        } finally {
            if (httpRequestBase!=null) {
                httpRequestBase.releaseConnection();
            }
            if (null != response) {
                response.close();
            }
        }
        return body;
    }


}
