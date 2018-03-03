package com.wxbc.fileoperator;

/**
 * Created by administrator on 17-9-4.
 */

public abstract class IFileUpload {

    public static final String FILE_TYPE_SCE = "SCEInfo";
    public static final String FILE_TYPE_CONTRACT = "contract";
    public static final String FILE_PDF = "pdf";
    public static final String FILE_JPG = "jpg";
    public static final String FILE_PNG = "png";
    public static final String FILE_DOC = "doc";
    public static final String FILE_DOCX = "docx";
    public static final String FILE_TXT = "txt";

    public boolean isExceedLimit(long fileSize) {
        return fileSize > 20 * 1024 * 1024;
    }

    public abstract boolean isFileTypeSupport(String fileSuffix);

}
