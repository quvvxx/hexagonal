package com.quvvxx.hexagonalpost.post.adapter.in.web.dto;

import com.quvvxx.hexagonalpost.post.application.dto.CreatePostResult;

public record CreatePostResponse(
        Long id,
        String title,
        String content
) {
    public static CreatePostResponse createPostResponse(CreatePostResult result){
        return new CreatePostResponse(result.id(), result.title(), result.content());
    }
}
