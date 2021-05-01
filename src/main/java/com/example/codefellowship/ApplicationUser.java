package com.example.codefellowship;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String username;
    String password;
    String firstname;
    String lastname;
    String dateofbirth;
    String bio;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    List<Post> posts;

    @ManyToMany
    @JoinTable(
            name="posters_and_followers",
            joinColumns = { @JoinColumn(name="follower") },
            inverseJoinColumns = { @JoinColumn(name = "poster")}
    )
    Set<ApplicationUser> usersIFollow;

    @ManyToMany(mappedBy = "usersIFollow")
    Set<ApplicationUser> usersFollowingMe;

    public void followUser(ApplicationUser followedUser){

        usersIFollow.add(followedUser);
    }

    public ApplicationUser() {}

    public ApplicationUser(String username,
                           String password,
                           String firstname,
                           String lastname,
                           String dateofbirth,
                           String bio) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.bio = bio;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDateOfBirth() {
        return dateofbirth;
    }

    public String getBio() {
        return bio;
    }

    public long getId() { return id; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateofbirth='" + dateofbirth + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }

    public Set<ApplicationUser> getUsersIFollow() {
        return usersIFollow;
    }

    public Set<ApplicationUser> getUsersFollowingMe() {
        return usersFollowingMe;
    }
}