package com.example.codefellowship;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class ApplicationUserController {
    @Autowired private PasswordEncoder passwordEncoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @PostMapping("/signup")
    public RedirectView signup(@RequestParam(value="username") String username,
                               @RequestParam(value="password") String password,
                               @RequestParam(value = "firstname") String firstname,
                               @RequestParam(value = "lastname") String lastname,
                               @RequestParam(value = "dateofbirth") String date,
                               @RequestParam(value = "bio") String bio) {

        if (applicationUserRepository.findByUsername(username) == null) {
            ApplicationUser u = new ApplicationUser(username, passwordEncoder.encode(password), firstname, lastname, date, bio);
            applicationUserRepository.save(u);
            Authentication authentication = new UsernamePasswordAuthenticationToken(u, null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            return new RedirectView("/");
        } else {
            return new RedirectView("/signup?taken=true");
        }
    }

    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/user/{id}")
    public String showUser(@PathVariable long id, Principal p, Model m) {

        ApplicationUser user = applicationUserRepository.findById(id).get();
        m.addAttribute("user", user);
        m.addAttribute("username", p.getName());
        return "userprofile";
    }

    @GetMapping("/userprofile")
    public String showCurrentUser(Principal p, Model m) {
        m.addAttribute("user", applicationUserRepository.findByUsername(p.getName()));
        m.addAttribute("username", p.getName());
        return "userprofile";
    }

    @GetMapping("/users")
    public String getAllUsers(Principal p, Model m) {
        m.addAttribute("username", p.getName());
        m.addAttribute("users", applicationUserRepository.findAll());

        return "allusers";
    }

    @PostMapping ("/follow")
    public RedirectView followUser(Principal p, long followUser) {

        ApplicationUser follower = applicationUserRepository.findByUsername(p.getName());
        ApplicationUser poster = applicationUserRepository.getOne(followUser);
        follower.followUser(poster);

        applicationUserRepository.save(follower);

        return new RedirectView("/userprofile");
    }
}