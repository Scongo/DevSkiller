package com.devskiller.exam.service;

import com.devskiller.exam.dto.CommentDto;
import com.devskiller.exam.dto.NewCommentDto;
import com.devskiller.exam.model.Comment;
import com.devskiller.exam.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepository commentRepository;
    @Override
    public List<CommentDto> getCommentsForPost(Long postId) {
        //TODO retrieve changes from from the db
        return List.of();

    }

    @Override
    public Long addComment(NewCommentDto newCommentDto) {
        Date date = new Date();
        Comment comment = new Comment();
        comment.setId(newCommentDto.getPostId());
        comment.setComment(newCommentDto.getContent());
        comment.setAuthor(newCommentDto.getAuthor());
        comment.setCreationDate(date);
        Comment newComment = commentRepository.save(comment);
        return newComment.getId();
    }
}
