package com.devskiller.exam.service;

import com.devskiller.exam.dto.PostDto;

import java.util.List;

public interface PostService {

    /**
     * Returns a blog post for passed id.
     * @param id id of the post
     * @return post data or null if no post is found for passed id
     */
    PostDto getPost(Long id);
}
