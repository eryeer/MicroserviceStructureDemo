package com.wxbc.common;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;


public class ResponseFormatWithItemMap<T> extends ResponseFormat<T>  {

    @Setter @Getter
    private Map<String,T> itemMap;

    public ResponseFormatWithItemMap(ReturnCode returnCode) {
        super(returnCode);
    }

    public ResponseFormatWithItemMap(ReturnCode returnCode, Map<String, T> itemMap) {
        super(returnCode);
        this.itemMap = itemMap;
    }

    public ResponseFormatWithItemMap(ReturnCode returnCode, List<T> items, Map<String, T> itemMap) {
        super(returnCode, items);
        this.itemMap = itemMap;
    }

    public ResponseFormatWithItemMap(int returnCode, String returnDesc, List<T> items, Map<String, T> itemMap) {
        super(returnCode, returnDesc, items);
        this.itemMap = itemMap;
    }

    @Override
    public String toString() {
        return "ResponseFormatWithItemMap{" +
                "itemMap=" + itemMap +
                "} " + super.toString();
    }
}

