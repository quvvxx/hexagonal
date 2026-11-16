package com.quvvxx.hexagonalpost.post.adapter.in.web.service;

import com.quvvxx.hexagonalpost.post.application.dto.CreatePostCommand;
import com.quvvxx.hexagonalpost.post.application.dto.CreatePostResult;
import com.quvvxx.hexagonalpost.post.domain.Post;
import com.quvvxx.hexagonalpost.post.port.in.CreatePostUseCase;
import com.quvvxx.hexagonalpost.post.port.out.SavePostPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService implements CreatePostUseCase {

    private final SavePostPort savePostPort;

    public CreatePostResult createPost(CreatePostCommand command){

        Post post = new Post(command.title(), command.content());
        Long savedId = savePostPort.save(post);

        return new CreatePostResult(savedId, post.getTitle(), post.getContent());
    }
}
