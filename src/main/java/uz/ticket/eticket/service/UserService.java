package uz.ticket.eticket.service;

import uz.ticket.eticket.payload.UserDTO;
import uz.ticket.eticket.response.ApiResponse;

public interface UserService {

    ApiResponse signup(UserDTO userDto);


}
