package uz.ticket.eticket.response;

import org.springframework.stereotype.Component;

@Component
public class BaseResponse  {
        public ApiResponse SUCCESS = new ApiResponse("Success", 0);
        public ApiResponse USER_NOT_FOUND = new ApiResponse("Username or password in correct", -10);
        public ApiResponse USER_ALREADY_EXISTS = new ApiResponse("User already exist ", -30);
        public ApiResponse NOT_FOUND = new ApiResponse("Not found", -30);
        public ApiResponse ALREADY_EXISTS = new ApiResponse(" already exist ", -30);
}
