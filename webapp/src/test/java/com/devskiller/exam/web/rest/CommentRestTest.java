package com.devskiller.exam.web.rest;


import com.devskiller.exam.dto.CommentDto;
import com.devskiller.exam.dto.NewCommentDto;
import com.devskiller.exam.service.CommentService;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestContext.class, MockedTestContext.class})
@WebAppConfiguration
public class CommentRestTest {

    private MockMvc mockMvc;

    @Autowired
    private CommentService commentService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        Mockito.reset(commentService);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void shouldReturnFoundComments() throws Exception{

        // given
        List<CommentDto> comments = new ArrayList<CommentDto>();
        Date creationDate = new Date();
        comments.add(new CommentDto(2L, "John Smith", "comment content", creationDate));

        // when
        when(commentService.getCommentsForPost(1L)).thenReturn(comments);

        // then
        mockMvc.perform(get("/post/1/comments").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(2)))
                .andExpect(jsonPath("$[0].author", is("John Smith")))
                .andExpect(jsonPath("$[0].comment", is("comment content")))
                .andExpect(jsonPath("$[0].creationDate", is(creationDate.getTime())));

    }
    @Test
    public void shouldAddComment() throws Exception{

        // given
        NewCommentDto newComment = createComment("Test content", "John Doe");
        newComment.setPostId(1L);

        // when
        when(commentService.addComment(newComment)).thenReturn(1L);

        // then
        mockMvc.perform(post("/post/1/comment")
                .content(TestUtil.convertObjectToJsonBytes(newComment))
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    private NewCommentDto createComment(String content, String author) {
        NewCommentDto newComment = new NewCommentDto();
        newComment.setContent(content);
        newComment.setAuthor(author);
        return newComment;
    }

}
