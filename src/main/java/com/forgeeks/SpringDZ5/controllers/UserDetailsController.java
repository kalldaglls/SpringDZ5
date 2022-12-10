package com.forgeeks.SpringDZ5.controllers;

import com.forgeeks.SpringDZ5.entities.User;
import com.forgeeks.SpringDZ5.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/userdata")
@RequiredArgsConstructor
public class UserDetailsController {
    private final UserService userService;
//    @GetMapping("/user/{id}")
//    public String getEmailByUsername(@PathVariable Long id) {
//        UserDetails user = userService.findByUserId(id);
//        return user.getPassword();
//    }
}
