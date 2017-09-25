package com.xiaobingby.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by XiaoBingBy on 2017/9/12.
 */
public class MD5Test {

    public static void main(String[] args) {
        int hashIterations = 1;//加密的次数
        Object salt = "123";//盐值
        Object credentials = "admin";//密码
        String hashAlgorithmName = "MD5";//加密方式
        Object simpleHash = new SimpleHash(hashAlgorithmName, credentials,
                salt, hashIterations);
        System.out.println("加密后的值----->" + simpleHash);
    }

}
