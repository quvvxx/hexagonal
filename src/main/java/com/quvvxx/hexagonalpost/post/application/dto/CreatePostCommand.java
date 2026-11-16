package com.quvvxx.hexagonalpost.post.application.dto;

public record CreatePostCommand(
        String title,
        String content
) {
}
