package com.example.demo.security;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@Getter
public class MyJwtException extends AuthenticationException {

    HttpStatus httpStatus;

    public MyJwtException(String msg, Throwable cause, HttpStatus httpStatus) {
        super(msg, cause);
        this.httpStatus = httpStatus;
    }

    public MyJwtException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }

    public MyJwtException(String msg) {
        super(msg);
    }
}
