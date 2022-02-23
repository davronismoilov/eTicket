package uz.ticket.eticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.user.User;
import uz.ticket.eticket.payload.UserDTO;
import uz.ticket.eticket.repository.UserRepository;
import uz.ticket.eticket.response.BaseResponse;

import java.util.Optional;


@Component
public class UserServiceImpl implements BaseResponse {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }


    public ResponseEntity<?> signup(UserDTO userDto) {
        Optional<User> byEmail = userRepository.findByEmail(userDto.getEmail());
        if (byEmail.isEmpty()) {
            User user = new User();
            user.setEmail(userDto.getEmail());
            user.setPhoneNumber(userDto.getMobileNumber());
            user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
            SUCCESS.setData(userRepository.save(user));
            return ResponseEntity.status(HttpStatus.CREATED).body(SUCCESS);

        }
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(USER_ALREADY_EXISTS);
    }


    public ResponseEntity<?> login(UserDTO userDto) {
        Optional<User> byEmail = userRepository.findByEmail(userDto.getEmail());
        if (byEmail.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(USER_NOT_FOUND);

        }
        if (bCryptPasswordEncoder.encode(userDto.getPassword()).equals(byEmail.get().getPassword())) {
            SUCCESS.setData(byEmail.get());
            return ResponseEntity.ok().body(SUCCESS);
        }

        return ResponseEntity.badRequest().body(NOT_FOUND);
    }


}
