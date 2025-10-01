package com.devskiller.exam.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.devskiller.exam.config.ServicesContext;
import com.devskiller.exam.dto.CommentDto;
import com.devskiller.exam.dto.NewCommentDto;
import com.devskiller.exam.model.Post;
import com.devskiller.exam.repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServicesContext.class)
@Transactional
public class CommentServiceTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentService commentService;

    @Test
    public void shouldAddComment() {
        Post post = createTestPost();

        NewCommentDto comment = new NewCommentDto();
        comment.setPostId(post.getId());
        comment.setAuthor("Author");
        comment.setContent("Content");
        Long commentId = commentService.addComment(comment);

        assertThat("Comment id shouldn't be null", commentId, notNullValue());
    }

    @Test
    public void shouldReturnAddedComment() {
        Post post = createTestPost();

        NewCommentDto comment = new NewCommentDto();
        comment.setPostId(post.getId());
        comment.setAuthor("Author");
        comment.setContent("Content");

        commentService.addComment(comment);

        List<CommentDto> comments = commentService.getCommentsForPost(post.getId());

        assertThat("There should be one comment", comments, hasSize(1));
        assertThat(comments.get(0).getAuthor(), equalTo("Author"));
        assertThat(comments.get(0).getComment(), equalTo("Content"));
    }

    private Post createTestPost() {
        Post post = new Post();
        post.setTitle("Test title");
        post.setContent("Test content");
        Date creationDate = new Date();
        post.setCreationDate(creationDate);
        postRepository.save(post);
        return post;
    }
}
