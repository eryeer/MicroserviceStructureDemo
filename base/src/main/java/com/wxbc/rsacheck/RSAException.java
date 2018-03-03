package com.wxbc.rsacheck;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by administrator on 17-8-29.
 */
public class RSAException extends Exception {
    public RSAException(java.lang.String s){
        super(s);

    }
}
