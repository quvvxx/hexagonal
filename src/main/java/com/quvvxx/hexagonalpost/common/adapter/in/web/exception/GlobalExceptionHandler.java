package com.quvvxx.hexagonalpost.common.adapter.in.web.exception;

import com.quvvxx.hexagonalpost.common.exception.BusinessException;
import com.quvvxx.hexagonalpost.common.exception.CommonErrorCode;
import com.quvvxx.hexagonalpost.common.exception.ErrorCode;
import com.quvvxx.hexagonalpost.common.exception.ErrorType;
import com.quvvxx.hexagonalpost.common.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleMethodArgumentException
            (MethodArgumentNotValidException e){

        ErrorCode errorCode = CommonErrorCode.VALIDATION_ERROR;

        ApiResponse<Void> response =
                ApiResponse.failure(errorCode);

        return ResponseEntity.status(toHttpStatus(errorCode.getType())).body(response);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponse<Void>> handleMethodNotSupportedException
            (HttpRequestMethodNotSupportedException e){

        ErrorCode errorCode = CommonErrorCode.METHOD_NOT_ALLOWED;

        ApiResponse<Void> response =
                ApiResponse.failure(errorCode);

        return ResponseEntity.status(toHttpStatus(errorCode.getType())).body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<Void>> handleMessageNotReadableException
            (HttpMessageNotReadableException e){

        ErrorCode errorCode = CommonErrorCode.INVALID_REQUEST_BODY;

        ApiResponse<Void> response =
                ApiResponse.failure(errorCode);

        return ResponseEntity.status(toHttpStatus(errorCode.getType())).body(response);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ApiResponse<Void>> handleMediaTypeNotSupportedException
            (HttpMediaTypeNotSupportedException e){

        ErrorCode errorCode = CommonErrorCode.UNSUPPORTED_MEDIA_TYPE;

        ApiResponse<Void> response =
                ApiResponse.failure(errorCode);

        return ResponseEntity.status(toHttpStatus(errorCode.getType())).body(response);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleNoResourceFoundException
            (NoResourceFoundException e){

        ErrorCode errorCode = CommonErrorCode.RESOURCE_NOT_FOUND;

        ApiResponse<Void> response =
                ApiResponse.failure(errorCode);

        return ResponseEntity.status(toHttpStatus(errorCode.getType())).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception e){

        log.error("예상치 못한 예외가 발생했습니다.", e);
        CommonErrorCode errorCode = CommonErrorCode.INTERNAL_SERVER_ERROR;
        ApiResponse<Void> response = ApiResponse.failure(errorCode);

        return ResponseEntity.status(toHttpStatus(errorCode.getType()))
                .body(response);
    }

    private HttpStatus toHttpStatus(ErrorType type){
        return switch (type){
            case BAD_REQUEST -> HttpStatus.BAD_REQUEST;
            case NOT_FOUND -> HttpStatus.NOT_FOUND;
            case METHOD_NOT_ALLOWED -> HttpStatus.METHOD_NOT_ALLOWED;
            case UNSUPPORTED_MEDIA_TYPE -> HttpStatus.UNSUPPORTED_MEDIA_TYPE;
            case INTERNAL_SERVER_ERROR -> HttpStatus.INTERNAL_SERVER_ERROR;
        };

    }
}
