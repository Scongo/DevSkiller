package com.devskiller.exam.repository;

import org.springframework.data.repository.CrudRepository;

import com.devskiller.exam.model.Comment;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAllByPostId(Long postId);
}
