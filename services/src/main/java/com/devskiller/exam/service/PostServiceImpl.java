package com.devskiller.exam.service;


import com.devskiller.exam.dto.PostDto;
import com.devskiller.exam.model.Post;
import com.devskiller.exam.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    public PostDto getPost(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            return new PostDto(post.get().getTitle(), post.get().getContent(), post.get().getCreationDate());
        } else {
            return null;
        }
    }
}
