package com.wxbc.common;

/**
 * Created by administrator on 17-9-14.
 */
public class CommonConst {
    public static final String PRODUCE = "application/json;charset=UTF-8";
    public static final String SP_CODE = "000000";
    public static final String TEL_REGEX = "[1]\\d{10}";
    public static final String CODE_REGEX = "^\\d{6}$";
    public static final String ACCOUNT_REGEX = "^\\d{0,30}$";
    public static final String BUSINESS_LICENSE_NUM_REGEX = "^[a-zA-Z0-9]{18}$";
    public static final String SCE_NAME_REGEX = "^[\\u4e00-\\u9fa5a-zA-Z0-9._-]{1,60}$";
    public static final String ACCOUNT_NAME_REGEX = "^[\\u4e00-\\u9fa5a-zA-Z0-9._-]{0,60}$";
    public static final String ACCOUNT_OPEN_BANK_REGEX = "^[\\u4e00-\\u9fa5a-zA-Z0-9._-]{0,60}$";
    public static final String CONTRACT_NAME_REGEX = "^[\\u4e00-\\u9fa5a-zA-Z0-9._-]{1,100}$";
    public static final String TAG_REGEX = "^[\\u4e00-\\u9fa5a-zA-Z0-9]{1,30}$";

    public static final String IP_REGEX = "\\d+\\.\\d+\\.\\d+\\.\\d+";

    public static final int BLN_MIN = 18;
    public static final int BLN_MAX = 80;


    public static final String TMPPath = "/tmp/";
    public static final String REGULATION_CONFIRM = "user/regulationConfirm";
    public static final Integer DR_BASE_VALUE_NOT_SETTED = 0;
    public static final Integer DR_BASE_VALUE_SETTED = 1;
    public static final Integer DR_BASE_VALUE_OMMIT = 2;
    public static final String DR_BASE_VALUE_APPLY = "申请企业基准定价";
    public static final String APPLY_DR_BASE_VALUE = "/applyDRBaseValue";
    public static final String DR_ACTIVE_GET = "获得可操作贴现率列表";
    public static final String GET_DR_ACTIVE = "/getDRActive";

    public static String businessLicenseNum = "businessLicenseNum";
    public static String businessLicenseFile = "businessLicenseFileID";
    public static String bankAccountCertFile = "bankAccountCertificateFileID";
    public static String organizationCreditCertFile = "organizationCreditCertificateFileID";
    public static String authorizationCreditInquiryFile = "authorizationCreditInquiryFileID";
    public static String legalRepresentativeIDFile = "legalRepresentativeIDFileID";
    public static String financialReportFile = "financialReportFileID";
    public static String constitutionID = "constitutionID";


    //  public static final String FileContractName = "FileInfoManager";
    //  public static final String FileServerName = "FileServerManager";
    public static final String CheckLoginCodePath = "checkLoginCode";
    public static final String GetUserKeyWithSigned = "getUserKeyWithSigned?pubKeySigned=";
    public static final String GetUserKeyWithSigned_URL = "getUserKeyWithSigned";
    public static final String ValidLoginCode = "validLoginCode";
    public static final String UpdateSCEKeyInfo = "updateSCEInfo";
    public static final String SendLoginCode = "validcode/sendLoginCode";
    public static final String GetCompanyInfo = "user/getCompanyInfo";
    public static final String GetSimpleCompanyInfo = "user/getSimpleCompanyInfo";
    public static final String GetFICompanyInfo = "user/getFICompanyInfo";
    public static final String GetAllFICompanyInfoSCE = "user/getAllFICompanyInfoSCE";
    public static final String GetCoCompanyInfoList = "user/getCoCompanyInfoList";
    public static final String OnceInsertCRecPubKey = "onceInsertCRecPubKey";

    public static final String RemarkCompanyInfo = "remarkCompanyInfo";
    public static final String UpdateContractInfo = "updateContractInfo";
    public static final String GetContractInfo = "GetContractInfo";

    public static final String CommitIV = "iv/commit";
    public static final String CancelIV = "iv/cancel";
    public static final String GetActiveIVList = "iv/getActiveIVList";
    public static final String GetAllIVList = "iv/getAllIVList";
    public static final String GetAllLastIVList = "iv/getAllLastIVList";
    public static final String ConfirmIV = "iv/confirm";
    public static final String RejectIV = "iv/reject";
    public static final String ApplyPayByC = "iv/applyPayIVByC";
    public static final String ConfirmPayIVByC = "iv/confirmPayIVByC";
    public static final String RejectPayIVByC = "iv/rejectPayIVByC";
    public static final String PayIVBySn = "iv/payIVBySn";
    public static final String CheckIVList = "iv/checkIVList";

    public static final String TRUE = "true";
    public static final String FALSE = "false";

    public static final String TOKEN = "access";
    public static final String IV_GetActList = "获取当前发票列表";
    public static final String IV_GetAllList = "获取所有发票列表";
    public static final String IV_GetAllLastList = "获取所有最新发票列表";
    public static final String IV_Commit = "录入发票";
    public static final String IV_Cancel = "撤销发票";
    public static final String IV_Reject = "拒绝发票";
    public static final String IV_Confirm = "核准发票";
    public static final String IV_Pay_APPLY_BY_C = "CA申请支付发票";
    public static final String IV_Pay = "支付发票";
    public static final String CONFIRM_PAYBYC = "CFM支付发票";
    public static final String REJECT_PAYBYC = "CFM拒绝支付发票";

    public static final String Company_GetCoContract = "查询企业相关合同信息";
    public static final String Company_Get_info = "查询企业信息";
    public static final String Company_Get_FI_info = "查询FI企业信息";
    public static final String Company_Remark_info = "核对企业信息";
    public static final String Company_Confirm_info = "确认企业信息";
    public static final String COMPANY_GET_SIMPLE_INFO = "查询企业信息简要";
    public static final String COMPANY_GET_INFO_LIST = "查询企业信息清单";

    public static final String Regulation_Confirm_info = "确认规则信息";

    public static final String COU_GetCICQCP = "获取CICQCP";
    public static final String GetCQCICP = "cou/getCQCICP";
    public static final String COU_SetCOUQuota = "设置COU额度";
    public static final String COU_GetCOUQuota = "获取COU额度";
    public static final String COU_GetCOUQuotaLog = "获取COU额度记录";
    public static final String GetCOUQuotaLog = "cou/getCQLog";

    public static final String CenterQuota = "centerQuota";
    public static final String CenterIssued = "centerIssued";
    public static final String CenterPaid = "centerPaid";
    public static final String CenterForzen = "centerForzen";


    public static final String GetActiveCOUList = "cou/getActiveCOUList";
    public static final String COU_GetActiveList = "获取当前COU列表";
    public static final String GetAllCOUList = "cou/getAllCOUList";
    public static final String GetAllLastCOUList = "cou/getAllLastCOUList";
    public static final String COU_GetAllList = "获取所有COU列表";
    public static final String COU_GetAllLastList = "获取所有最新COU列表";
    public static final String GETCOUHISTORYLIST = "cou/getCOUHistoryList";
    public static final String COU_GETCOUHISTORYLIST = "获取COU历史记录列表";
    public static final String API_BcosPayIvByC = "bcosPayIvByC";
    public static final String API_BcosPayIvBySn = "bcosPayIvBySn";
    public static final String COU_QueryFinApp = "查询融资申请通知";
    public static final String QueryFinApply = "queryFinApply";
    public static final String COU_SetFinLoan = "设置放款处理结果";
    public static final String COU_QueryDRAdjustStatus = "查询融资成本调整通知";
    public static final String QueryDRAdjustStatus = "queryDRAdjust";
    public static final String RegFIConfig = "FI注册配置";
    public static final String RegFIConfigUrl = "regFIConfig";
    public static final String COU_GetFinLoan = "获取放款处理日志";
    public static final String COU_Accept = "接收COU";
    public static final String AcceptCOU = "cou/accept";
    public static final String DR_GetALL = "获取所有DR";
    public static final String GetALLDR = "dr/getAll";
    public static final String QueryDRAdjustLog = "dr/queryDRAdjustLog";
    public static final String SET_DR_BASE_VALUE = "设置融资成本基准定价";
    public static final String SET_DR_BASE_VALUE_URL = "setDRBaseValue";
    public static final String SET_DR_SHIFT_RANGE = "设置融资成本浮动定价";
    public static final String SET_DR_SHIFT_RANGE_URL = "setDRShiftRange";
    public static final String SET_DR_FINAL_VALUE = "设置融资成本最终定价";
    public static final String SET_DR_FINAL_VALUE_URL = "setDRFinalValue";


    public static final String DR_Setup = "设置DR值";
    public static final String DR_Delete = "删除DR值";
    public static final String DeleteDRDegree = "dr/deleteDRDegree";
    public static final String GetDRInfo = "getDRInfo";
    public static final String GetAllDRInfo = "getAllDRInfo";
    public static final String SetCompanyDRDegree = "dr/setCompanyDRDegree";
    public static final String SetupDrDegree = "dr/setupDRDegree";
    public static String COMPANY_INFO_STATUS_UNCONFIRM = "uncheck";
    public static String COMPANY_INFO_STATUS_NEEDTOUPDATE = "needtoupdate";
    public static String COMPANY_INFO_STATUS_CONFIRM = "checked";
    public static String INVALID_ACCESS = "Invalid Access";
    public static String PUBKEY = "pubKey";

    public static final String MicroAdjustCompanyDR = "dr/microAdjustCompanyDR";
    public static final String QueryCompanyDRAdjustLog = "dr/queryCompanyDRAdjustLog";
    public static final String QueryCompanyDRMicroAdjustLog = "dr/queryCompanyDRMicroAdjustLog";

    public static final String COU_GetCOUMaturityDateLog = "查询COU期限";
    public static final String COU_GetCOUMaturityDateLog_REST = "查询COU期限REST接口";
    public static final String GetCOUMaturityDateLog = "/getCOUMaturityDateLog";
    public static final String COU_SetCOUMaturityDate = "调整COU期限";
    public static final String SetCOUMaturityDate = "/setCOUMaturityDate";
    public static final String COU_GetCOUMaturityDateByRange = "按调整日期查询COU期限";
    public static final String GetCOUMaturityDateByRange = "/getCOUMaturityDateByRange";

    public static final String COU_Finance = "COU融资";
    public static final String FinanceCOU = "cou/dfccou";
    public static final String COU_CancelDFC = "撤销融资";
    public static final String CancelDFC = "cou/cancelDFC";
    public static final String COU_ProcessCMD = "处理到期兑付";
    public static final String ProcessCMD = "cou/processCMD";
    public static final String COU_ApplyCMD = "申请到期兑付";
    public static final String ApplyCMD = "cou/applyCMD";
    public static final String COU_PayCMD = "到期付款";
    public static final String PayCMD = "cou/CMD";

    public static final String STATUS_ONPROCESS = "OnProcess";
    public static final String STATUS_WAITFI = "WaitingForFIUpdate";

    public static final String ACTIVE = "active";
    public static final String FROZEN = "frozen";
    public static final String INIT = "init";

    public static final String API_COULoanState="COULoanState";  //放款状态
    public static final String API_COURequest="COURequest";  //融资申请
    public static final String API_applyDRBaseValue ="applyDRBaseValue";  //需定价企业信息推送

    public static final String BCOS_API_DFC = "bcosDFC";
    public static final String BCOS_API_CMD = "bcosCMD";


    public static final String COU_GetPubKey = "获取Public Key";
    public static final String COU2FI = "确认融资申请";
    public static final String COU_2FI = "cou/cou2fi";
    public static final String CMD_Done = "确认收款";
    public static final String DoneCMD = "cou/doneCMD";

    public static final String DOWNLOAD_URL = "/downloadFile";

    public static final String DATASOURCE_FRONT = "front";
    public static final String DATASOURCE_BACK = "backend";

    public static final String EMAIL_SMTP_HOST = "mail.smtp.host";
    public static final String EMAIL_TRANSPORT_PROTOCAL = "mail.transport.protocol";
    public static final String EMAIL_SMTP_AUTH = "mail.smtp.auth";
    public static final String EMAIL_SMTP_PORT = "mail.smtp.port";
    public static final String EMAIL_CONTENT_TYPE = "text/html;charset=UTF-8";
    public static final String SEND_EMAIL = "sendEmail";
    public static final String EMAIL_PROCESS_PAYCOU_SN = "qclz";
    public static final String EMAIL_PROCESS_APPLY_PAYCOU_C = "qrzf";
    public static final String EMAIL_PROCESS_DFC2FI = "dfc2FI";
    public static final String EMAIL_PROCESS_DFC2C = "dfc2C";
    public static final String EMAIL_PROCESS_REJUECT_PAYCOU_CF="zfjj";

    public static final String DR_WAIT4SHIFT = "wait4Shift";
    public static final String DR_WARIT4FINAL = "wait4Final";
    public static final String DR_FINAL_DONE = "finalDone";
    public static final String DR_INIT = "init";

    public static final String GetPubKeyWithSigned = "根据签名获取公钥";


    public static final String REST_GetCICQCP = "getCICQCP";  //tonglian
    public static final String REST_SetCOUQuota = "setCOUQuota"; //tonglian

    public static final int COMPANY_TYPE_C = 2;
    public static final int SMS_TMP_REGISTER = 56977;
    public static final int SMS_TMP_LOGIN = 56976;
    public static final int SMS_TMP_RECOVER = 56972;
    public static final int SMS_TMP_AUTH = 56974;

    public static final int REG_CONFIRMED = 1;
    public static final int REG_NOT_CONFIRMED = 0;


    public static long IDLE_CONNECTION_TIME = 60000;
}
