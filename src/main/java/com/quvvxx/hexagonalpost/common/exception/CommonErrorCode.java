package com.quvvxx.hexagonalpost.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode{

    INTERNAL_SERVER_ERROR(ErrorType.INTERNAL_SERVER_ERROR, "서버 내부 오류 발생");

    private final ErrorType type;
    private final String message;
}
