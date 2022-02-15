package uz.ticket.eticket.response;

import org.springframework.stereotype.Component;

@Component
public    interface BaseResponse {
         ApiResponse SUCCESS = new ApiResponse("Success", 0);
         ApiResponse USER_NOT_FOUND = new ApiResponse("Username or password in correct", -10);
         ApiResponse USER_ALREADY_EXISTS = new ApiResponse("User already exist ", -30);
}
