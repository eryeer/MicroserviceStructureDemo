package com.wxbc.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by administrator on 17-9-14.
 */
public class CacheController {

    private static Map<String, String> hmCredit = new HashMap<>();

    public static void putNameAndPassword(String name,String password){
        hmCredit.put(name,password);
    }

    public static String getPassword(String name) {
        return hmCredit.get(name);
    }
}
