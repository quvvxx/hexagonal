package com.quvvxx.hexagonalpost.common.exception.response;

import com.quvvxx.hexagonalpost.common.exception.ErrorCode;

public record ErrorResponse(
        String code,
        String message
) {
    public static ErrorResponse of(ErrorCode errorCode) {
        return new ErrorResponse(errorCode.name(), errorCode.getMessage());
    }
}
