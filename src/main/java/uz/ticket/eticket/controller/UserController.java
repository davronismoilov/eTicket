package uz.ticket.eticket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/user")
public class UserController {

    @PostMapping("/login")
    public void login(){

    }

    @PostMapping("/register")
    public void register(){

    }


}
