package com.quvvxx.hexagonalpost.post.domain;

import com.quvvxx.hexagonalpost.post.domain.exception.PostErrorCode;
import com.quvvxx.hexagonalpost.post.domain.exception.PostException;
import lombok.Getter;

@Getter
public class Post {

    private final String title;
    private final String content;
    private static final int MAX_LENGTH = 255;

    public Post(String title, String content){

        if (title == null || title.isBlank())
            throw new PostException(PostErrorCode.POST_TITLE_EMPTY);

        if (title.length() > MAX_LENGTH)
            throw new PostException(PostErrorCode.POST_TITLE_TOO_LONG);

        if (content == null || content.isBlank())
            throw new PostException(PostErrorCode.POST_CONTENT_EMPTY);

        if (content.length() > MAX_LENGTH)
            throw new PostException(PostErrorCode.POST_CONTENT_TOO_LONG);

        this.title = title;
        this.content = content;
    }
}
