package com.wxbc.servicebean.manager;

import com.wxbc.servicebean.PubKeyInfo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

@Setter
@Getter
public class RegulationInfo extends PubKeyInfo {

    private String regulation;
    private String regulationBrief;
    private String regulationSigned;
    @Pattern(regexp = "^check|confirm$")
    private String type;

    @Override
    public String toString() {
        return "RegulationInfo{" +
                "regulation='" + regulation + '\'' +
                ", regulationBrief='" + regulationBrief + '\'' +
                ", regulationSigned='" + regulationSigned + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}