package com.devskiller.exam.dto;

import java.util.Date;

public class CommentDto {

    private Long id;

    private String author;

    private String comment;

    private Date creationDate;

    public CommentDto(Long id, String author, String comment, Date creationDate) {
        this.id = id;
        this.author = author;
        this.comment = comment;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public String getAuthor() {
        return author;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
