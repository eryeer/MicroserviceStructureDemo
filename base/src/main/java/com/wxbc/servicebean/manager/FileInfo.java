package com.wxbc.servicebean.manager;

import com.wxbc.common.BaseInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by administrator on 17-9-6.
 */
@Getter
@Setter
public class FileInfo extends BaseInfo {

    private String fileOwner;
    private String fileName;
    private String fileData;

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileOwner='" + fileOwner + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileData='" + fileData + '\'' +
                '}';
    }
}
