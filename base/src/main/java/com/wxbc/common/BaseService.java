package com.wxbc.common;

import java.util.List;

public class BaseService {

    public boolean isEmpty(List lst) {
        if (lst == null) {
            return true;
        }
        if (lst.size() == 0) {
            return true;
        }
        return false;
    }
}


