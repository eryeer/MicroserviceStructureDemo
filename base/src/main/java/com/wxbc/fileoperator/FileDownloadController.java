package com.wxbc.fileoperator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wxbc.security.ECCUtils;
import com.wxbc.common.AppPropReader;
import com.wxbc.common.CommonConst;
import com.wxbc.common.CommonUtil;
import com.wxbc.common.httpclient.HttpClient;
import com.wxbc.operlog.OperLogAnnotation;
import com.wxbc.servicebean.contract.ContractInfo;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by fengxinhe on 2017/8/19.
 */
@Controller
@RequestMapping(value = "/file")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FileDownloadController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    @ApiOperation(value = "下载文件信息", notes = "下载文件信息")
    @OperLogAnnotation(description = "下载文件信息")
    @RequestMapping(value = CommonConst.DOWNLOAD_URL, method = RequestMethod.GET)
    public void download(@RequestParam String fileId, @RequestParam String pubKeyBrief, @RequestParam String
            pubKeySigned, HttpServletResponse res) {
        try {

            String pubKey = CommonUtil.getUserKeyInfo(pubKeySigned).getPubKey();
            boolean checkResult = ECCUtils.verify(pubKeyBrief, pubKey, pubKeySigned);
            if (!checkResult) {
                logger.info("checkResult false:");
                return;
            }
            ContractInfo contractInfo = new ContractInfo();
            contractInfo.setPubKeyBrief(pubKeyBrief);
            contractInfo.setPubKeySigned(pubKeySigned);
            contractInfo.setId(Integer.parseInt(fileId));

            String url = AppPropReader.getRestUrl() + CommonConst.GetContractInfo;
            try {
                //从adminAcess获取文件内容
                ObjectMapper mapper = new ObjectMapper();
                String responseBody =HttpClient.sendPost(url,  contractInfo);
                ResponseFormat_FileInfo responseFormat = mapper.readValue(responseBody, ResponseFormat_FileInfo.class);

                String fileData =responseFormat.getItems().get(0).getFileData();
                String fileName = responseFormat.getItems().get(0).getFileName();
                byte[] filecontent = org.apache.commons.codec.binary.Base64.decodeBase64(fileData);

                String ISOFileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
                res.setHeader("content-type", "application/octet-stream");
                res.setContentType("application/octet-stream");
                res.setHeader("Content-Disposition", "attachment;filename=" + ISOFileName);

                try {
                    InputStream bis = new BufferedInputStream(new ByteArrayInputStream(filecontent));
                    IOUtils.copy(bis, res.getOutputStream());
                    res.flushBuffer();
                } catch (IOException e) {
                    logger.error("getContractInfo IOException:", e);
                }
            } catch (Exception e) {
                logger.error("getContractInfo:", e);
            }

        } catch (Exception e) {
            logger.error("downloadFile", e);
        }
    }
}
