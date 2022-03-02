package uz.ticket.eticket.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ticket.eticket.payload.UserDTO;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.service.UserService;

import java.io.IOException;


@RestController
@RequestMapping("/api/user")

public class UserController {
    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO user) {
        return userService.login(user);

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO user) {
        return userService.register(user);

    }

    @GetMapping("/all_users")
    public ResponseEntity<?> allUsers()  {
        return userService.getAllUsers();
    }

    @GetMapping("/download/users")
    public ResponseEntity<?> getUsersExel() throws IOException {
        return ResponseEntity.ok().body(userService.getUserFile());
    }


}



