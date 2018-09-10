package com.xiaobingby.encrypt;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author XiaoBingBy
 * @date 2018-08-30 14:41
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EncryptTests {

    @Autowired
    StringEncryptor encryptor;

    @Test
    public void jasyptTest() {
        String username = encryptor.encrypt("");
        String password = encryptor.encrypt("");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("uri: " +  encryptor.encrypt(""));
    }

}
