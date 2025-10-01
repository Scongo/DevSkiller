package com.devskiller.exam.web;

import com.devskiller.exam.service.CommentService;
import com.devskiller.exam.service.PostService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;

public class MockedTestContext {

    @Bean
    public PostService postService() {
        return Mockito.mock(PostService.class);
    }

    @Bean
    public CommentService commentService() {
        return Mockito.mock(CommentService.class);
    }
}
