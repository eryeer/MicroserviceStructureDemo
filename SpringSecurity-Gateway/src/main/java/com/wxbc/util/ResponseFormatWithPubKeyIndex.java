package com.wxbc.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

public class ResponseFormatWithPubKeyIndex<T> extends ResponseFormat<T> {
    @Setter
    @Getter
    private Map<Integer, String> pubKeyIndexes;

    public ResponseFormatWithPubKeyIndex(ReturnCode returnCode) {
        super(returnCode);
    }

    public ResponseFormatWithPubKeyIndex() {
    }

    public ResponseFormatWithPubKeyIndex(int returnCode, String returnDesc, List<T> items, Map<Integer, String> pubKeyIndexes) {
        super(returnCode, returnDesc, items);
        this.pubKeyIndexes = pubKeyIndexes;
    }

    @Override
    public String toString() {
        return "ResponseFormatWithPubKeyIndex{" +
                "pubKeyIndexes=" + pubKeyIndexes +
                '}';
    }
}