package com.quvvxx.hexagonalpost.post.adapter.in.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreatePostRequest(

        @Size(max = 255)
        @NotBlank(message = "게시글 제목은 비어있을 수 없습니다.")
        String title,

        @Size(max = 255)
        @NotBlank(message = "게시글 내용은 비어있을 수 없습니다.")
        String content
) {
}
