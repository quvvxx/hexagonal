package com.quvvxx.hexagonalpost.post.domain.exception;

import com.quvvxx.hexagonalpost.common.exception.BusinessException;

public class PostException extends BusinessException {
    public PostException(PostErrorCode errorCode) {
        super(errorCode);
    }
}
