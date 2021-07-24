package com.vijay.springbootlearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/")
    public String home() {
        return ("<h1> Welcome !!</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1> Welcome to User!!</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1> Welcome to Admin !!</h1>");
    }
}
