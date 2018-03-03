package com.wxbc.security;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Hash;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Sign;
import org.web3j.utils.Numeric;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by mawenjing on 2017/10/27.
 */
public class ECCUtils {


    public static final String KEY_ALGORITHM = "EC";

    public static final String KEY_STD_NAME = "secp256k1";//TODO复写生成密钥函数

    public static final String ENCRYPT_ALGORITHM = "AES/CBC/PKCS5Padding";

    protected static Logger logger = LoggerFactory.getLogger(ECCUtils.class);

    //此处由于string转为key形式没有好的转换函数，因此只能通过string拼接key的类结构，再转换为key。
    // 因此此处两个header其实是对应prikey和pubkey的java类结构
    public static final String PRIVATE_KEY_HEADER =
            "303E020100301006072A8648CE3D020106052B8104000A042730250201010420";

    public static final String PUBLIC_KEY_HEADER =
            "3056301006072A8648CE3D020106052B8104000A03420004";

    public static ECKeyPair generateKeyPair() throws Exception {
        ECKeyPair ecKeyPair = Keys.createEcKeyPair();
        return ecKeyPair;
    }

    private static final String FILE_NAME_SERVICE = "fi_config_service.json";
    private static final String FILE_NAME_RECOVER = "fi_config_recover.json";

    public static final String PUBLIC_KEY = "ECCPublicKey";
    public static final String PRIVATE_KEY = "ECCPrivateKey";

    public static Map<String, String> initKey() throws Exception {
        HashMap<String, String> map = new HashMap<>();
        String priKey = generatePriKey();
        String pubKey = generatePubKey(priKey);
        map.put(PUBLIC_KEY, pubKey);
        map.put(PRIVATE_KEY, priKey);
        return map;

    }

    /* out base64 String*/
    private static String generatePriKey() throws Exception {
        //generate a new keypair
        ECKeyPair ecKeyPair = generateKeyPair();

        //privateKey evolved from BigInteger to ByteArray (Don't use the method 'toByteArray'), then to String with base64
        BigInteger priKeyBI = ecKeyPair.getPrivateKey();
        byte[] priKeyByte = Numeric.hexStringToByteArray(priKeyBI.toString(16));
        String priKey = encodeBase64(priKeyByte);
        return priKey;
    }

    /*
     * in:  base64 String
     * out: base64 String
     */
    private static String generatePubKey(String priKey) throws Exception {
        // privateKey evolve from String to BigInteger
        byte[] priKeyByte = decodeBase64(priKey);
        BigInteger priKeyBI = Numeric.toBigInt(priKeyByte);

        //publicKey evolved from BigInteger to ByteArray (Don't use the method 'toByteArray'), then to String with base64
        BigInteger pubKeyBI = Sign.publicKeyFromPrivate(priKeyBI);
        String pubKey = pubKeyBigIntToStr(pubKeyBI);
        return pubKey;
    }

    /*
     * in:  string，base64 String
     * out: base64 String
     */
    public static String signData(String dataStr, String priKey) throws Exception {

        //accordance with javacript
        //byte[] prefix = ("\u0019Ethereum Signed Message:\n" + Integer.toString(data.length)).getBytes();
        //byte[] msg = addBytes(prefix, data);

        // privateKey evolve from String to BigInteger
        byte[] data = dataStr.getBytes();
        byte[] priKeyByte = decodeBase64(priKey);
        BigInteger priKeyBI = Numeric.toBigInt(priKeyByte);

        //sign message with keypair
        ECKeyPair KEY_PAIR = ECKeyPair.create(priKeyBI);
        Sign.SignatureData signatureData = Sign.signMessage(data, KEY_PAIR);

        byte[] sign = addBytes(signatureData.getR(), signatureData.getS());
        SignObj signJson = new SignObj();
        signJson.r = encodeBase64(signatureData.getR());
        signJson.s = encodeBase64(signatureData.getS());
        signJson.v = signatureData.getV();
        String jsonStr = JSON.toJSONString(signJson);
        return jsonStr;
    }

    /*
     * in:  string，base64 String, base64 String
     * out: boolean
     */
    public static boolean verify(String dataStr, String pubKey, String sign) throws Exception {
        byte[] data = dataStr.getBytes();
        // pubKeyByte evolve from String to BigInteger
        BigInteger pubKeyBI = pubKeyStrToBigInt(pubKey);
        SignObj signJson = JSON.parseObject(sign, SignObj.class);
        //byte[] signByte = decodeBase64(sign);
        byte[] r = decodeBase64(signJson.r);
        byte[] s = decodeBase64(signJson.s);
        byte v = signJson.v;
        Sign.SignatureData signatureVerify = new Sign.SignatureData(v, r, s);
        BigInteger pubkeyVerify = Sign.signedMessageToKey(data, signatureVerify);

        return pubKeyBI.equals(pubkeyVerify);
    }

    /*
     * in:  string，base64 String
     * out: base64 String
     */
    private static String signString(String dataStr, String priKey) throws Exception {
        byte[] data = dataStr.getBytes();
        // privateKey evolve from String to BigInteger
        byte[] priKeyByte = decodeBase64(priKey);
        BigInteger priKeyBI = Numeric.toBigInt(priKeyByte);

        //sign message with keypair
        ECKeyPair KEY_PAIR = ECKeyPair.create(priKeyBI);
        Sign.SignatureData signatureData = Sign.signMessage(data, KEY_PAIR);
        byte[] sign = signToByteArray(signatureData);
        return encodeBase64(sign);
    }

    /*
     * in:  string，base64 String, base64 String
     * out: boolean
     */
    private static boolean verifyString(String dataStr, String pubKey, String sign) throws Exception {
        byte[] data = dataStr.getBytes();
        // pubKeyByte evolve from String to BigInteger
        BigInteger pubKeyBI = pubKeyStrToBigInt(pubKey);

        byte[] signData = decodeBase64(sign);
        Sign.SignatureData signatureVerify = byteArrayToSign(signData);
        BigInteger pubkeyVerify = Sign.signedMessageToKey(data, signatureVerify);

        return pubKeyBI.equals(pubkeyVerify);
    }

    /*
     * in:  base64 String,base64 String,
     * out: base64 String,
     */
    private static String generateSecret(String pubKey, String priKey) throws Exception {

        //converter string to key Obj
        PublicKey publicKey = hexStrToPublicKey(pubKey);
        PrivateKey privateKey = hexStrToPrivateKey(priKey);
        //实例化
        KeyAgreement keyAgree = KeyAgreement.getInstance("ECDH");
        //初始化
        keyAgree.init(privateKey);
        keyAgree.doPhase(publicKey, true);
        //生成本地密钥
        byte[] secretByte = keyAgree.generateSecret();
        return encodeBase64(secretByte);
    }

    /*
     * in:  String,base64 String,
     * out: base64 String,
     */
    private static String encryptBySecret(String data, String secret) throws Exception {

        // secret evolve from String to byte[]
        byte[] secretByte = decodeBase64(secret);

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
        SecretKeySpec skeySpec = new SecretKeySpec(secretByte, "AES");

        //use CBC mode ,iv is needed
        byte[] ivbuf = silceBytes(Hash.sha3(data.getBytes()), 0, 16);
        IvParameterSpec iv = new IvParameterSpec(ivbuf);//使用CBC模式，需要一个向量iv，可增加加密算法的强度

        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(data.getBytes("utf-8"));
        byte[] cipherData = addBytes(ivbuf, encrypted);
        return encodeBase64(cipherData);
    }

    /*解密
     * in:  base64 String, base64 String,
     * out: String,
     */
    private static String decryptBySecret(String cipherData, String secret) throws Exception {

        // secret evolve from String to byte[]
        byte[] secretByte = decodeBase64(secret);
        byte[] cipherByte = decodeBase64(cipherData);

        SecretKeySpec skeySpec = new SecretKeySpec(secretByte, "AES");
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);

        //get iv and encrypted from cipherData
        byte[] ivbuf = silceBytes(cipherByte, 0, 16);
        byte[] encryptedbuf = silceBytes(cipherByte, 16, (cipherByte.length - 16));
        IvParameterSpec iv = new IvParameterSpec(ivbuf);

        //decrypt data
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] original = cipher.doFinal(encryptedbuf);

        String originalString = new String(original, "utf-8");
        return originalString;
    }

    /*
     * in:  String, base64 String, base64 String,
     * out: base64 String,
     */
    public static String encrypt(String data, String pubKeyTo, String priKeySelf) throws Exception {

        //generate secret by ECDH
        String secret = generateSecret(pubKeyTo, priKeySelf);
        String cipherStr = encryptBySecret(data, secret);
        return cipherStr;
    }

    /*解密
     * in:  base64 String, base64 String,, base64 String,
     * out: String,
     */
    public static String decrypt(String cipherData, String pubKeyTo, String priKeySelf) throws Exception {

        //generate secret by ECDH
        String secret = generateSecret(pubKeyTo, priKeySelf);
        String originalString = decryptBySecret(cipherData, secret);
        return originalString;
    }


    public static byte[] decodeBase64(String value) {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] keyBytes = null;
        try {
            keyBytes = base64Decoder.decodeBuffer(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyBytes;
    }

    public static String encodeBase64(byte[] bytes) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encodeBuffer(bytes);

    }

    private static byte[] addBytes(byte[] data1, byte[] data2) {
        byte[] data3 = new byte[data1.length + data2.length];
        System.arraycopy(data1, 0, data3, 0, data1.length);
        System.arraycopy(data2, 0, data3, data1.length, data2.length);
        return data3;
    }

    private static byte[] silceBytes(byte[] data, int position, int length) {
        byte[] outData = new byte[length];
        System.arraycopy(data, position, outData, 0, length);
        return outData;
    }

    private static byte[] signToByteArray(Sign.SignatureData signatureData) {
        byte[] R = signatureData.getR();
        byte[] S = signatureData.getS();
        byte V = signatureData.getV();
        byte[] sign = addBytes(signatureData.getR(), signatureData.getS());
        byte[] signV = new byte[1];
        signV[0] = signatureData.getV();
        byte[] data = new byte[R.length + S.length + 1];
        System.arraycopy(R, 0, data, 0, R.length);
        System.arraycopy(S, 0, data, R.length, S.length);
        data[R.length + S.length] = V;
        return data;
    }

    public static Sign.SignatureData byteArrayToSign(byte[] data) {

        Integer LENGTH_SIGN = 32;
        Integer pos = 0;
        byte[] R = new byte[LENGTH_SIGN];
        byte[] S = new byte[LENGTH_SIGN];
        System.arraycopy(data, pos, R, 0, LENGTH_SIGN);
        pos += LENGTH_SIGN;
        System.arraycopy(data, pos, S, 0, LENGTH_SIGN);
        pos += LENGTH_SIGN;
        byte V = data[pos];
        Sign.SignatureData signatureData = new Sign.SignatureData(V, R, S);
        return signatureData;
    }

    public static PrivateKey hexStrToPrivateKey(String priKey) throws Exception {
        byte[] priKeyByte = addBytes(Numeric.hexStringToByteArray(PRIVATE_KEY_HEADER), decodeBase64(priKey));
        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //初始化私钥
        //密钥材料转换
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(priKeyByte);
        PrivateKey privateKeyObj = null;
        try {
            //产生私钥
            privateKeyObj = keyFactory.generatePrivate(pkcs8KeySpec);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(new BigInteger(1, priKeyByte).toString(16));
            System.out.print(PRIVATE_KEY_HEADER);
        }
        return privateKeyObj;
    }

    public static PublicKey hexStrToPublicKey(String pubKey) throws Exception {


        byte[] pubKeytemp = decodeBase64(pubKey);
        byte[] pubKeyUncom = Arrays.copyOfRange(pubKeytemp, 1, pubKeytemp.length);//需要把首位04去掉
        byte[] pubKeyByte = addBytes(Numeric.hexStringToByteArray(PUBLIC_KEY_HEADER), pubKeyUncom);
        //实例化密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //初始化公钥
        //密钥材料转换
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pubKeyByte);
        //产生公钥
        PublicKey publicKeyObj = keyFactory.generatePublic(x509KeySpec);
        return publicKeyObj;
    }

    private static BigInteger pubKeyStrToBigInt(String pubKey) {
        byte[] pubKeyByte = decodeBase64(pubKey);
        byte[] pubKeyUncom = Arrays.copyOfRange(pubKeyByte, 1, pubKeyByte.length);//需要把首位04去掉
        BigInteger pubKeyBI = Numeric.toBigInt(pubKeyUncom);
        return pubKeyBI;
    }

    private static String pubKeyBigIntToStr(BigInteger pubKey) {
        byte[] pubKeyByte = Numeric.hexStringToByteArray(pubKey.toString(16));

        //需要把首位04加上
        byte[] pubKeyByteUnCom = addBytes(Numeric.hexStringToByteArray("04"), pubKeyByte);

        String pubKeyStr = encodeBase64(pubKeyByteUnCom);
        return pubKeyStr;
    }

    public static String SHA256(final String strText) {
        return SHA(strText, "SHA-256");
    }

    private static String SHA(final String strText, final String strType) {
        String strResult = null;

        if (strText != null && strText.length() > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                messageDigest.update(strText.getBytes());
                byte byteBuffer[] = messageDigest.digest();

                StringBuffer strHexString = new StringBuffer();
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return strResult;
    }


    public static class SignObj {
        public String r;
        public String s;
        public byte v;
    }

}
