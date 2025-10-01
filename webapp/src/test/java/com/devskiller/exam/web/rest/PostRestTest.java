package com.devskiller.exam.web.rest;


import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.devskiller.exam.dto.PostDto;
import com.devskiller.exam.service.PostService;
import com.devskiller.exam.web.MockedTestContext;
import com.devskiller.exam.web.config.RestContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestContext.class, MockedTestContext.class})
@WebAppConfiguration
public class PostRestTest {

    private MockMvc mockMvc;

    @Autowired
    private PostService postService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        Mockito.reset(postService);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void shouldReturnFoundPost() throws Exception{

        // given
        Date creationDate = new Date();
        PostDto post = new PostDto("Title", "content", creationDate);

        // when
        when(postService.getPost(1L)).thenReturn(post);

        // then
        mockMvc.perform(get("/post/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.title", is("Title")))
                .andExpect(jsonPath("$.content", is("content")))
                .andExpect(jsonPath("$.creationDate", is(creationDate.getTime())));

    }
}
