package uz.ticket.eticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.Role;
import uz.ticket.eticket.entity.User;
import uz.ticket.eticket.payload.UserDTO;
import uz.ticket.eticket.repository.UserRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by Arpit Khandelwal.
 */
@Component
public class UserServiceImpl implements BaseResponse {

    private  final BCryptPasswordEncoder bCryptPasswordEncoder;

    private  final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }



    public ResponseEntity<?> signup(UserDTO userDto) {
        Optional<User> byEmail = userRepository.findByEmail(userDto.getEmail());
        if (!byEmail.isPresent()) {
            User user = new User();
            user.setEmail(userDto.getEmail());
            user.setPhoneNumber(userDto.getMobileNumber());
            user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
            SUCCESS.setData(userRepository.save(user));
            return ResponseEntity.status(HttpStatus.CREATED).body(SUCCESS);

        }
        return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(USER_ALREADY_EXISTS);
    }




}
