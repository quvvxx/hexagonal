package com.quvvxx.hexagonalpost.common.exception;

public interface ErrorCode {
    ErrorType getType();
    String name();
    String getMessage();
}
