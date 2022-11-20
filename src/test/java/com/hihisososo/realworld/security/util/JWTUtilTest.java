package com.hihisososo.realworld.security.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JWTUtilTest {

    private JWTUtil jwtUtil = new JWTUtil();

    @Test
    void testEncode() throws Exception {
        String email = "jake@jake.jake";

        System.out.println(jwtUtil.generateToken(email));
    }

    @Test
    void testValidate() throws Exception {
        String email = "jake@jake.jake";

        String token = jwtUtil.generateToken(email);

        Thread.sleep(5000);

        String resultEmail = jwtUtil.validateAndExtract(token);

        System.out.println(resultEmail);
    }

    @Test
    void testError() throws Exception {
        String email = "jake@jake.jake";

        String token = jwtUtil.generateToken(email);

        Thread.sleep(5000);

        String resultEmail = jwtUtil.validateAndExtract(token.substring(1));

        System.out.println(resultEmail);
    }
}