package com.quvvxx.hexagonalpost.adapter.in.web.exception;

import com.quvvxx.hexagonalpost.common.exception.BusinessException;
import com.quvvxx.hexagonalpost.common.exception.CommonErrorCode;
import com.quvvxx.hexagonalpost.common.exception.ErrorCode;
import com.quvvxx.hexagonalpost.common.exception.ErrorType;
import com.quvvxx.hexagonalpost.common.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Void>> handleBusinessException(BusinessException e){

        ErrorCode errorcode = e.getErrorCode();
        ApiResponse<Void> response = ApiResponse.failure(errorcode);

        return ResponseEntity.status(toHttpStatus(errorcode.getType()))
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception e){

        log.error("예상치 못한 예외가 발생했습니다.", e);
        CommonErrorCode errorCode = CommonErrorCode.INTERNAL_SERVER_ERROR;
        ApiResponse<Void> response = ApiResponse.failure(errorCode);

        return ResponseEntity.status(toHttpStatus(errorCode.getType()))
                .body(response);
    }

    public HttpStatus toHttpStatus(ErrorType type){
        return switch (type){
            case BAD_REQUEST -> HttpStatus.BAD_REQUEST;
            case NOT_FOUND -> HttpStatus.NOT_FOUND;
            case INTERNAL_SERVER_ERROR -> HttpStatus.INTERNAL_SERVER_ERROR;
        };

    }
}
