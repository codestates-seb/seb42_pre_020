package com.sof.Users.exception;

import lombok.Getter;
import org.springframework.web.client.HttpClientErrorException;

public enum ExceptionCode {
    USER_EXIST(404, "이미 존재하는 회원입니다."),
    USER_NOT_FOUND(404, "찾을 수 없는 회원입니다."),
    PASSWORD_NO(400, "비밀번호가 틀렸습니다"),
    NO_LOGIN(401, "로그인이 필요합니다."),

    NO_USER_INFO(400, "사용자 정보가 일치하지 않습니다.");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}