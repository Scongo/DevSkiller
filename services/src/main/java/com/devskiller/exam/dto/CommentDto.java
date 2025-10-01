package com.devskiller.exam.dto;

import java.util.Date;

public class CommentDto {

    private Long id;

    private String comment;

    private String author;

    private Date creationDate;

    public CommentDto(Long id, String comment, String author, Date creationDate) {
        this.id = id;
        this.comment = comment;
        this.author = author;
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
