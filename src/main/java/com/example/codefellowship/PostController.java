package com.example.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Controller
public class PostController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    PostRepository postRepository;
//    @GetMapping("/post")
//    public String getSignUpPage(){
//        return "post.html";
//    }

//    @PostMapping("/post")
//    public RedirectView post(
//            @RequestParam(value="postedBy") String postedBy,
//            @RequestParam(value="createdAt") String createdAt,
//            @RequestParam(value="body") String body ){
//       Post newPost = new Post(postedBy,body,createdAt);
//        newPost = postRepository.save(newPost);
//
//        return new RedirectView("/post");
//    }



    @PostMapping("/addPost")
    public RedirectView addPost(@RequestParam String body, Principal p){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        String formatDateTime = now.format(format);
        ApplicationUser user=applicationUserRepository.findByUsername(p.getName());
        Post post =new Post(user,formatDateTime,body);
        postRepository.save(post);
        return  new RedirectView("/myprofile");
    }
}
