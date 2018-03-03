package com.wxbc.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by administrator on 17-9-14.
 */
public class CacheController {

    private static Map<String, String> hmCredit = new HashMap<>();

    public static void putBriefAndSigned(String brief,String signed){
        hmCredit.put(brief,signed);
    }

    public static String getSigned(String brief) {
        return hmCredit.get(brief);
    }
}
