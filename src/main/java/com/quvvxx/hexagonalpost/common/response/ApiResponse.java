package com.quvvxx.hexagonalpost.common.response;

import com.quvvxx.hexagonalpost.common.exception.ErrorCode;
import com.quvvxx.hexagonalpost.common.exception.response.ErrorResponse;

public record ApiResponse<T> (
    boolean success,
    T data,
    ErrorResponse error
){
    public static <T> ApiResponse<T> success(T data){
        return new ApiResponse<>(true, data, null);
    }

    public static ApiResponse<Void> failure(ErrorCode errorCode) {
        return new ApiResponse<>(false, null, ErrorResponse.of(errorCode));
    }
}
