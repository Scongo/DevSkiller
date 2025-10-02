package com.devskiller.exam.service;

import com.devskiller.exam.dto.CommentDto;
import com.devskiller.exam.dto.NewCommentDto;
import com.devskiller.exam.model.Comment;
import com.devskiller.exam.model.Post;
import com.devskiller.exam.repository.CommentRepository;
import com.devskiller.exam.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;
    @Override
    public List<CommentDto> getCommentsForPost(Long postId) {
        List<Comment> comments = commentRepository.findAllByPostId(postId);

        return comments.stream()
                .map(comment -> new CommentDto(
                        comment.getId(),
                        comment.getAuthor(),
                        comment.getComment(),
                        comment.getCreationDate()
                )).collect(Collectors.toList());
    }

    @Override
    public Long addComment(NewCommentDto newCommentDto) {
        Post post = postRepository.findById(newCommentDto.getPostId())
                .orElseThrow(() -> new IllegalArgumentException("Is not be found : " + newCommentDto.getPostId()));

        Comment comment = new Comment();
        comment.setPost(post);
        comment.setAuthor(newCommentDto.getAuthor());
        comment.setComment(newCommentDto.getContent());
        comment.setCreationDate(new Date());

        Comment savedComment = commentRepository.save(comment);
        return savedComment.getId();
    }
}
