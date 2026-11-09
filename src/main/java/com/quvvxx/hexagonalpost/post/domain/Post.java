package com.quvvxx.hexagonalpost.post.domain;

import com.quvvxx.hexagonalpost.post.domain.exception.PostErrorCode;
import com.quvvxx.hexagonalpost.post.domain.exception.PostException;
import lombok.Getter;

@Getter
public class Post {

    private final String title;
    private final String content;

    public Post(String title, String content){
        if (title == null || title.isBlank())
            throw new PostException(PostErrorCode.POST_TITLE_EMPTY);

        if (content == null || content.isBlank())
            throw new PostException(PostErrorCode.POST_CONTENT_EMPTY);

        this.title = title;
        this.content = content;
    }
}
