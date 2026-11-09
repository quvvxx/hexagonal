package com.quvvxx.hexagonalpost.post.domain.exception;

import com.quvvxx.hexagonalpost.common.exception.ErrorCode;
import com.quvvxx.hexagonalpost.common.exception.ErrorType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PostErrorCode implements ErrorCode {
    POST_TITLE_EMPTY(ErrorType.BAD_REQUEST, "게시글 제목은 비어있을 수 없습니다."),
    POST_CONTENT_EMPTY(ErrorType.BAD_REQUEST, "게시글 내용은 비어있을 수 없습니다.");

    private final ErrorType type;
    private final String message;
}
