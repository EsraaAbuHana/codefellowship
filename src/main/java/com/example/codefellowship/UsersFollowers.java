package com.example.codefellowship;

import javax.persistence.*;

@Entity
public class UsersFollowers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @MapsId("userid")
    @JoinColumn(name = "id")
    ApplicationUser applicationUser;

    @ManyToOne
    @MapsId("followerid")
    @JoinColumn(name = "id")
    ApplicationUser applicationUserFollower;
}
