package com.wxbc.util;

/**
 * Created by administrator on 17-9-19.
 */
public enum ReturnCode {
    CREATE_SUCCESS(1000),
    CREATE_DUPLICATE(1001),
    CREATE_FAILED(1002),
    READ_SUCCESS(2000),
    READ_FAILED(2001),
    READ_NOMATCH(2002),
    READ_FAILED_REGISTER_CODE_USED(2003),
    READ_FAILED_REGISTER_CODE_INVALID(2004),
    UPDATE_SUCCESS(3000),
    UPDATE_NOMATCH(3001),
    UPDATE_FAILED(3002),
    UPLOAD_SUCCESS(4000),
    UPLOAD_FAILED(4001),
    PARAMETER_ERROR(5001),
    VALID_CODE_1MIN(5002),
    CONTRACT_NOT_MATCH(5003),
    FILE_EXCEED_LIMIT(5004),
    FILE_SUFFIX_INVALID(5005),
    REGISTER_SCE_FAILED(5006),
    PUBKEY_VALID_FAILED(5007),
    SEND_VALID_CODE_FAILED(5008),
    IV_EXIST(5009),
    WARINING_FAILED(5010),
    IV_SIGNED_FAILED(5011),
    IV_SIGNED_CANCEL_FAILED(5012),
    IV_NOT_EXIST(5013),
    RUN_FAILED(9001),
    PHONE_NUM_NOT_EXIST(5014),
    PUB_KEY_NOT_EXIST(5015),
    IV_COUPAY_FAILED(5016),
    COMPANY_NOT_EXIST(5017),
    IV_PAY_FAILED(5017),
    COU_SIGNED_FAILED(5018),
    COU_NOT_EXIST(5019),
    COU_NOT_MATCH(5020),
    COU_IN_PROCESS(5021),
    DATABASE_EXCEPTION(5022), DRDEGREEID_NOTEXIST(5023), DRDEGREEID_USED(5024),
    DR_SIGNED_FAILED(5025), SESSION_EXPIRED(5026), CENTER_COMPANY_ERROR(5027), COMPANY_TYPE_ERROR(5028),
    CMDAMOUNT_ERROR(5029),
    FI_IS_NOT_ACTIVE(5030),
    PARAM_ERROR_PHONE_REPEAT(5031),
    PARAM_ERROR_PHONE_NOTMATCH(5032), PARAM_ERROR_PHONE_EXCEED(5033), PARAM_ERROR_ROLE_ERROR(5034), PARAM_PASS(5035),
    PARAM_ERROR_PHONE_ERROR(5036),
    IV_CONTRACT_ID_ERROR(5037),
    CONTRACT_UPDATE_FAIL(5038),
    FI_ADJUST_STATUS_FAIL(5039),
    CONTRACT_TO_SCE_NAME_FAIL(5040),
    NO_ACTIVE_FI(5041),
    CONFIRMED_REG(5042),
    SEND_EMAIL_FAILED(5043),
    LOGIN_CODE_ERROR(5044),
    SESSION_KICKAWAY(5045),
    IV_ALREADY_PAY(5046),
    CONTRACT_ID_REPEAT(5047),
    TIME_ERROR(5048),
    R_COMPANY_DUPULICATED(5049),
    IV_ALREADY_APPLY_PAY(5050),
    BLN_NOT_EXIST(5051),
    STATUS_WRONG(5052),
    DR_SHIFT_RANGE__SINGED_ERROR(5053),
    DR_SHIFT_RANGE_VALUE_ERROR(5054),
    DR_FINAL_VALUE_SINGED_ERROR(5055),
    DR_FINAL_VALUE_ERROR(5056),
    CONFIRMED_REG_SMS_BANNED(5057);


    private int value;

    private ReturnCode(int value) {
        this.value = value;
    }

    public String getDesc() {
        switch (this) {
            case CREATE_SUCCESS:
                return "Create/Insert Success";
            case CREATE_DUPLICATE:
                return "Create/Insert Duplicated";
            case READ_SUCCESS:
                return "Read/Search Success";
            case READ_NOMATCH:
                return "Read/Search No Matched";
            case UPDATE_SUCCESS:
                return "Update Success";
            case UPDATE_NOMATCH:
                return "Update No Matched";
            case UPDATE_FAILED:
                return "Update Failed";
            case UPLOAD_SUCCESS:
                return "Upload Success";
            case UPLOAD_FAILED:
                return "Upload Failed";
            case RUN_FAILED:
                return "API Run Failed";
            case PARAMETER_ERROR:
                return "参数非法";

            case VALID_CODE_1MIN:
                return "60S内不能重复发送手机注册码";
            case FILE_EXCEED_LIMIT:
                return "文件超过20M";
            case FILE_SUFFIX_INVALID:
                return "文件后缀非法";
            case REGISTER_SCE_FAILED:
                return "用户注册失败";
            case PUBKEY_VALID_FAILED:
                return "签名验证失败";
            case SEND_VALID_CODE_FAILED:
                return "发送验证码失败";
            case IV_EXIST:
                return "发票已经存在，发票提交失败";
            case WARINING_FAILED:
                return "warning验签失败,发票审核失败";
            case IV_CONTRACT_ID_ERROR:
                return "合同与发票不匹配，发票审核失败";
            case IV_SIGNED_FAILED:
                return "验签失败,发票提交失败";
            case IV_SIGNED_CANCEL_FAILED:
                return "验签失败,发票撤销失败";

            case COU_SIGNED_FAILED:
                return "验签失败,COU接收失败";

            case IV_NOT_EXIST:
                return "发票不存在，发票撤销失败";
            case PHONE_NUM_NOT_EXIST:
                return "手机号码不存在";
            case PUB_KEY_NOT_EXIST:
                return "公钥信息不存在";
            case IV_COUPAY_FAILED:
                return "COU验签失败，发票支付失败";
            case COMPANY_NOT_EXIST:
                return "企业信息不存在";
            case IV_PAY_FAILED:
                return "发票支付验签失败，发票支付失败";

            case COU_NOT_EXIST:
                return "COU不存在";
            case COU_NOT_MATCH:
                return "你没有权限处理这个COU！";
            case COU_IN_PROCESS:
                return "COU在处理中.";
            case DATABASE_EXCEPTION:
                return "数据库异常";
            case DRDEGREEID_NOTEXIST:
                return "融资成本档位不存在.";
            case DRDEGREEID_USED:
                return "融资成本档位在使用中,不能删除.";
            case DR_SIGNED_FAILED:
                return "融资成本签名验证失败";
            case SESSION_EXPIRED:
                return "系统已登出，请重新登录";
            case CENTER_COMPANY_ERROR:
                return "只能有一个中心企业";
            case COMPANY_TYPE_ERROR:
                return "企业类型错误";
            case CMDAMOUNT_ERROR:
                return "到期兑付金额不匹配";
            case FI_IS_NOT_ACTIVE:
                return "金融机构已冻结";
            case FI_ADJUST_STATUS_FAIL:
                return "金融机构初始状态不正确,调整运行状态失败！";
            case PARAM_ERROR_PHONE_REPEAT:
                return "手机号码重复";
            case PARAM_ERROR_PHONE_NOTMATCH:
                return "手机号码和角色不匹配";
            case PARAM_ERROR_PHONE_EXCEED:
                return "手机角色信息不对";
            case PARAM_ERROR_ROLE_ERROR:
                return "角色错误";
            case PARAM_ERROR_PHONE_ERROR:
                return "手机号码非法";
            case PARAM_PASS:
                return "参数校验通过";
            case CONTRACT_UPDATE_FAIL:
                return "存在和该合同关联的发票，修改合同失败！";
            case CONTRACT_TO_SCE_NAME_FAIL:
                return "交易对方不能为空！";
            case NO_ACTIVE_FI:
                return "没有运行中的金融机构！";
            case CONFIRMED_REG:
                return "规则已经确认过,请勿重复提交！";
            case LOGIN_CODE_ERROR:
                return "验证码错误或已失效！";
            case SEND_EMAIL_FAILED:
                return "发送邮件通知失败";
            case SESSION_KICKAWAY:
                return "此账号在其他机器重新登录.";
            case IV_ALREADY_PAY:
                return "发票已经支付,请勿重复提交！";
            case IV_ALREADY_APPLY_PAY:
                return "发票已经提交支付申请";
            case BLN_NOT_EXIST:
                return "统一信用码不存在";
            case STATUS_WRONG:
                return "记录状态不合法";
            case DR_SHIFT_RANGE__SINGED_ERROR:
                return "浮动定价签名验证失败";
            case DR_SHIFT_RANGE_VALUE_ERROR:
                return "浮动定价范围校验有误";
            case  DR_FINAL_VALUE_SINGED_ERROR:
                return "最终定价签名验证失败";
            case DR_FINAL_VALUE_ERROR:
                return "最终定价验证失败";
            case CONFIRMED_REG_SMS_BANNED:
                return "规则已确认，不能发送注册码";
            default:
                return null;
        }
    }

    public int getValue() {
        return this.value;
    }


}

