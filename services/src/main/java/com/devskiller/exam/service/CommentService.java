package com.devskiller.exam.service;

import com.devskiller.exam.dto.CommentDto;
import com.devskiller.exam.dto.NewCommentDto;

import java.util.List;

public interface CommentService {

    /**
     * Returns a list of all comments for a blog post with passed id.
     * @param postId id of the post
     * @return list of comments sorted by creation date descending - most recent first
     * @throws IllegalArgumentException if there is no blog post for passed postId
     */
    List<CommentDto> getCommentsForPost(Long postId);

    /**
     * Creates a new comment
     * @param newCommentDto data of new comment
     * @return id of created comment
     * @throws IllegalArgumentException if there is no blog post for passed newCommentDto.postId
     */
    Long addComment(NewCommentDto newCommentDto);
}
