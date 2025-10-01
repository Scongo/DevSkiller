package com.devskiller.exam.web.rest;

import com.devskiller.exam.dto.PostDto;
import com.devskiller.exam.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PostDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }
}
