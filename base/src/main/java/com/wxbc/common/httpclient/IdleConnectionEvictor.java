package com.wxbc.common.httpclient;

import com.wxbc.common.CommonConst;
import org.apache.http.conn.HttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;

/**
 * 定期清理无效的http连接
 * @Author: Zhaochen
 * @Description:
 * @Date: created in 2:22 PM 1/3/17
 */
public class IdleConnectionEvictor extends Thread {

    protected Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private final HttpClientConnectionManager connMgr;
    
    private Integer waitTime;

    private volatile boolean shutdown;

    public IdleConnectionEvictor(HttpClientConnectionManager connMgr,Integer waitTime) {
        this.connMgr = connMgr;
        this.waitTime = waitTime;
        this.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(waitTime);
                    // 关闭失效的连接
                    connMgr.closeExpiredConnections();
                    connMgr.closeIdleConnections(CommonConst.IDLE_CONNECTION_TIME, TimeUnit.MILLISECONDS);
                    logger.info("Expired connections closed");
                }
            }
        } catch (InterruptedException ex) {
            // 结束
        }
    }

    /**
     * 销毁释放资源
     */
    @PreDestroy
    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
        logger.info("IdleConnectionEvictor shutdown");
    }
}
