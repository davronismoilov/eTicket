package uz.ticket.eticket.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.user.User;
import uz.ticket.eticket.payload.UserDTO;
import uz.ticket.eticket.repository.user.UserRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;


import java.util.Optional;


@Component
public class UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final BaseResponse baseResponse;

    @Autowired
    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, ModelMapper mapper, BaseResponse baseResponse) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.baseResponse = baseResponse;
    }


    public ResponseEntity<?> register(UserDTO userDto) {
        Optional<User> byEmail = userRepository.findByUsername(userDto.getUsername());
        if (byEmail.isEmpty()) {
            User user = mapper.map(userDto, User.class);
            ApiResponse SUCCESS = baseResponse.getSUCCESS();
            SUCCESS.setData(userRepository.save(user));
            return ResponseEntity.ok().body(SUCCESS);

        }
        return ResponseEntity.ok().body(baseResponse.getUSER_ALREADY_EXISTS());
    }


    public ResponseEntity<?> login(UserDTO userDto) {
        Optional<User> byEmail = userRepository.findByUsername(userDto.getUsername());
        if (byEmail.isEmpty()) {
            return ResponseEntity.ok().body(baseResponse.getUSER_NOT_FOUND());

        }
        if (byEmail.get().getPassword().equals(userDto.getPassword())) {
            ApiResponse SUCCESS = baseResponse.getSUCCESS();
            SUCCESS.setData(byEmail.get());
            return ResponseEntity.ok().body(SUCCESS);
        }

        return ResponseEntity.ok().body(baseResponse.getUSER_NOT_FOUND());
    }


}
