package com.quvvxx.hexagonalpost.post.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
