package com.quvvxx.hexagonalpost.post.port.out;

import com.quvvxx.hexagonalpost.post.domain.Post;

public interface SavePostPort {
    Post save(Post post);
}
