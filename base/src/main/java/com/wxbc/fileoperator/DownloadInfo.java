package com.wxbc.fileoperator;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by administrator on 17-9-19.
 */
@Getter
@Setter
public class DownloadInfo extends PubKeyInfo {
    @NotBlank
    private String fileId;

    @Override
    public String toString() {
        return "DownloadInfo{" +
                "fileId='" + fileId + '\'' +
                '}';
    }
}
