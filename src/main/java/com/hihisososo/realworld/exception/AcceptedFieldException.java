package com.hihisososo.realworld.exception;

public class AcceptedFieldException extends RuntimeException {
    public AcceptedFieldException(String field) {
        super("허용되지 않는 필드입니다. " + field);
    }
}
