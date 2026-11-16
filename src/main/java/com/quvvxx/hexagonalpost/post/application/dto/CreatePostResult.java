package com.quvvxx.hexagonalpost.post.application.dto;

public record CreatePostResult(
        Long id,
        String title,
        String content
) {
}
