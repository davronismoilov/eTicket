package uz.ticket.eticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ticket.eticket.payload.UserDTO;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.service.UserService;

@RestController
@RequestMapping("/api/user")

public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ApiResponse login(@RequestBody UserDTO user) {
        System.out.println(user);
        return userService.login(user);

    }

    @PostMapping("/register")
    public ApiResponse register(@RequestBody UserDTO user) {
        return userService.register(user);

    }

}



