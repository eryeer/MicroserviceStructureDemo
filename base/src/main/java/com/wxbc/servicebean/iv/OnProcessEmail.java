package com.wxbc.servicebean.iv;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by administrator on 17-11-14.
 */
@Getter
@Setter
public @Validated class OnProcessEmail{

    @Pattern(regexp = "qclz|qrzf|dfc2C|dfc2FI|dr")
    private String operation;

    @NotNull
    private int preProcessId;

    @NotNull
    private String snName;

    public OnProcessEmail(String operation, int preProcessId, String snName){
        this.operation = operation;
        this.preProcessId = preProcessId;
        this.snName = snName;
    }

    @Override
    public String toString() {
        return "OnProcessEmail{" +
                "operation='" + operation + '\'' +
                ", preProcessId=" + preProcessId +
                ", snName='" + snName + '\'' +
                '}';
    }
}