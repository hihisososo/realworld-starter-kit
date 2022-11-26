package com.hihisososo.realworld.exception;

public class DuplicateMemberException extends RuntimeException {
    public DuplicateMemberException() {
        super("중복된 유저가 있습니다");
    }
}
