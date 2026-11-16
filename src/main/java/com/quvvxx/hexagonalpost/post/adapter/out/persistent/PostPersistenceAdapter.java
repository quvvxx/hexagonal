package com.quvvxx.hexagonalpost.post.adapter.out.persistent;

import com.quvvxx.hexagonalpost.post.domain.Post;
import com.quvvxx.hexagonalpost.post.port.out.SavePostPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostPersistenceAdapter implements SavePostPort {

    private final PostRepository postRepository;

    @Override
    public Long save(Post post) {

        PostEntity postEntity = PostEntity.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .build();

        PostEntity savedPost = postRepository.save(postEntity);

        return savedPost.getId();
    }
}
