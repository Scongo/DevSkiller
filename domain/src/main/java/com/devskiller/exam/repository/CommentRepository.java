package com.devskiller.exam.repository;

import org.springframework.data.repository.CrudRepository;

import com.devskiller.exam.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
