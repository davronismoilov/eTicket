package uz.ticket.eticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ticket.eticket.entity.User;
import uz.ticket.eticket.payload.UserDTO;

import uz.ticket.eticket.service.UserServiceImpl;

@RestController
@RequestMapping("/api/user")
public class UserController {
    final
    UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserDTO user) {
        return userService.signup(user);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody UserDTO user) {
        return userService.signup(user);
    }



}



