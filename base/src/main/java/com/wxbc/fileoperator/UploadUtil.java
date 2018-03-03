package com.wxbc.fileoperator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by administrator on 17-9-12.
 */
public class UploadUtil {
    protected static Logger logger = LoggerFactory.getLogger("UploadUtil");


//    public static String uploadfile2DFS(String bln, MultipartFile file, String path, String filePath, File
//            destFile) {
//        String fileID= null;
//        try {
//            CommonUtil.mkdirs(path);
//
//            file.transferTo(destFile);
//            fileID = EngineUtil.getInstance().fileUpload(bln, "rw", filePath);
//
//        } catch (IOException e) {
//            logger.info("uploadFile  ：", e);
//        }
//        return fileID;
//    }

    public static String getFileSuffix(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex == -1) {
            logger.error("File lack of suffix.");
            return null;
        }
        return fileName.substring(fileName.indexOf('.') + 1, fileName.length());
    }

}
