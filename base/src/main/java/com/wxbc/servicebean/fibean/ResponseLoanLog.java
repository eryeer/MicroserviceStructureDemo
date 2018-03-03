package com.wxbc.servicebean.fibean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by administrator on 17-10-9.
 */
@Getter
@Setter
public class ResponseLoanLog extends  ResponseBase {
    private List<RequestFinanceLoan> loanLogs;
    public ResponseLoanLog() {
        this.setReturnCode(returnCode_200);
    }

    @Override
    public String toString() {
        return "ResponseLoanLog{" +
                "loanLogs=" + loanLogs +
                '}';
    }
}
