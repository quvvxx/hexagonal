package com.quvvxx.hexagonalpost.post.port.in;

import com.quvvxx.hexagonalpost.post.application.dto.CreatePostCommand;
import com.quvvxx.hexagonalpost.post.application.dto.CreatePostResult;

public interface CreatePostUseCase {
    CreatePostResult createPost(CreatePostCommand command);
}
