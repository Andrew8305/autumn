package com.cloud.common.util.jwt;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JiaShun
 * @date 2018/3/28 16:45
 */
public class RsaKeyHelper {
    /**
     * 根据前端请求密码生成秘钥和私钥byte[]数组并存入map
     * @param password
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    public static Map<String,byte[]> generateKey(String password) throws IOException,NoSuchAlgorithmException{
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(password.getBytes());
        keyPairGenerator.initialize(1024,secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();
        byte[] pubKeyBytes = keyPair.getPublic().getEncoded();
        byte[] priKeyBytes = keyPair.getPrivate().getEncoded();
        Map<String,byte[]> map = new HashMap<>();
        map.put("pub",pubKeyBytes);
        map.put("pri",priKeyBytes);
        return map;
    }

    /**
     * 获取公钥
     * @param pubKey
     * @return
     * @throws Exception
     */
    public PublicKey getPubKey(byte[] pubKey) throws Exception{
        X509EncodedKeySpec spec = new X509EncodedKeySpec(pubKey);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    /**
     * 获取私钥
     * @param priKey
     * @return
     * @throws Exception
     */
    public PrivateKey getPriKey(byte[] priKey) throws Exception{
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(priKey);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    //String 转 byte[]
    public static final byte[] toBytes(String s) throws IOException{
        return (new BASE64Decoder()).decodeBuffer(s);
    }
    //byte[] 转 String
    public static String toHexString(byte[] b){
        return (new BASE64Encoder()).encodeBuffer(b);
    }
}
