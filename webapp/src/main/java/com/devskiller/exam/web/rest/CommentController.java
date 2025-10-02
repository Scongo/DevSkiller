package com.devskiller.exam.web.rest;

import com.devskiller.exam.dto.CommentDto;
import com.devskiller.exam.dto.NewCommentDto;
import com.devskiller.exam.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
@RequestMapping("/post")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping(value = "/{postId}/comments", produces = APPLICATION_JSON_VALUE)
    public List<CommentDto> getCommentsForPost(@PathVariable Long postId) {
        return commentService.getCommentsForPost(postId);
    }

    @PostMapping(value = "/{postId}/comment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addComment(@PathVariable Long postId,
                                           @RequestBody NewCommentDto newCommentDto) {
        if (!postId.equals(newCommentDto.getPostId())) {
            return ResponseEntity.badRequest().build();
        }
        commentService.addComment(newCommentDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
