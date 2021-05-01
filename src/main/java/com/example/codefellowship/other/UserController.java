package com.example.codefellowship.other;

import com.example.codefellowship.ApplicationUserRepository;
import com.example.codefellowship.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private ApplicationUserRepository applicationUserRepository;
    @Autowired
    private PostRepository postRepository;

}
