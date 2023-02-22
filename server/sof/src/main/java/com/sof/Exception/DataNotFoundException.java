package com.sof.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entity not found")
public class DataNotFoundException extends RuntimeException{
    //serialVersionUID: 직렬화 버전의 고유값 = 직렬화/역직렬화 할 때 해당 클래스 특정 버전을 판단함
    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String message) { super(message); }
}
