package com.example.codefellowship;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String body;
    @ManyToOne
    private ApplicationUser postedBy;
    private String createdAt;
    public Post(ApplicationUser postedBy, String body, String createdAt) {
        this.body=body;
        this.postedBy=postedBy;
        this.createdAt=createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Post(String postedBy, String body) {
    }

    public int getId() {
        return id;
    }



    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ApplicationUser getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(ApplicationUser postedBy) {
        this.postedBy = postedBy;
    }
}
