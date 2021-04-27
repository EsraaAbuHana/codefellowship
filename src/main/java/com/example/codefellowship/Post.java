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
