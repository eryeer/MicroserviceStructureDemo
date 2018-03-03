package com.wxbc.rolemanager;

import com.wxbc.rolemanager.bean.RoleInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by administrator on 17-8-30.
 */
public class RoleMapper {


    private static Map<String, List<String>> urlMap = new HashMap<String, List<String>>();

    public static final String CPRegManagement = "cpRegManagement";
    public static final String couDateManagement = "couDateManagement";
    public static final String fiManagement = "fiManagement";

    static {
        urlMap.put(RoleInfo.ROLE_SPOperator, new ArrayList<String>(asList(CPRegManagement, fiManagement, couDateManagement)));
        urlMap.put(RoleInfo.ROLE_CAuthorizer, new ArrayList<String>());
        urlMap.put(RoleInfo.ROLE_COperator, new ArrayList<String>());
        urlMap.put(RoleInfo.ROLE_CFManager, new ArrayList<String>());
        urlMap.put(RoleInfo.ROLE_FIRole, new ArrayList<String>());
        urlMap.put(RoleInfo.ROLE_SnAuthorizer, new ArrayList<String>());
        urlMap.put(RoleInfo.ROLE_SnOperator, new ArrayList<String>());

    }

    public static List<String> getURLLst(List<String> roleNames) {

        List<String> urls = new ArrayList<>();
        for (String str : roleNames) {
            List<String> url = urlMap.get(str);
            if (url != null) {
                urls.addAll(url);
            }
        }
        return urls;
    }
}
