package com.wxbc.servicebean;

/**
 * Created by administrator on 17-9-6.
 */
public enum COMPANY_TYPE {


    SP(1, "服务提供商"), CENTER(2, "中心企业"), SCN(3, "供应商"), FI(4, "金融机构"),R(5, "观察企业");

    private int type;
    private String value;

    COMPANY_TYPE(int type, String value) {
        this.value = value;
        this.type = type;

    }

    public static int getIntValue(String type) {
        for (COMPANY_TYPE ctype : COMPANY_TYPE.values())
            if (ctype.value.equals(type)) {
                return ctype.type;
            }
        return -1;
    }

    public static String getCompanyType(int type) {
        for (COMPANY_TYPE ctype : COMPANY_TYPE.values())
            if (ctype.getType() == type) {
                return ctype.value;
            }
        return "";
    }

    public int getType() {
        return type;
    }

    public String toString() {
        return value;
    }
}
