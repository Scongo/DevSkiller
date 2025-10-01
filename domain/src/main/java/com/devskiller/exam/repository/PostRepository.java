package com.devskiller.exam.repository;

import com.devskiller.exam.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
