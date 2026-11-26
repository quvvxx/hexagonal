package com.quvvxx.hexagonalpost.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode{

    VALIDATION_ERROR(ErrorType.BAD_REQUEST, "입력값이 올바르지 않습니다."),
    INVALID_REQUEST_BODY(ErrorType.BAD_REQUEST, "요청 본문 형식이 올바르지 않습니다."),

    RESOURCE_NOT_FOUND(ErrorType.NOT_FOUND, "요청한 리소스를 찾을 수 없습니다."),

    METHOD_NOT_ALLOWED(ErrorType.METHOD_NOT_ALLOWED, "지원하지 않는 HTTP 메서드 입니다."),

    UNSUPPORTED_MEDIA_TYPE(ErrorType.UNSUPPORTED_MEDIA_TYPE, "지원하지 않는 Content-Type입니다"),

    INTERNAL_SERVER_ERROR(ErrorType.INTERNAL_SERVER_ERROR, "서버 내부 오류가 발생했습니다.");


    private final ErrorType type;
    private final String message;
}
