package uz.ticket.eticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.ticket.eticket.model.User;
import uz.ticket.eticket.repository.UserRepository;
import uz.ticket.eticket.response.ApiResponse;

@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ApiResponse  login(@RequestBody User user){
         return  userRepository.login(user);

    }

    @PostMapping("/register")
    public void register(){

    }


}
