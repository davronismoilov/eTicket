package uz.ticket.eticket.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter

public class BaseResponse {

    ApiResponse SUCCESS = new ApiResponse("Success", 0);
    ApiResponse UNSUCCESS = new ApiResponse("Unsuccess", 0);
    ApiResponse USER_NOT_FOUND = new ApiResponse("Username or password in correct", -10);
    ApiResponse USER_ALREADY_EXISTS = new ApiResponse("User already exist ", -30);
    ApiResponse NOT_FOUND = new ApiResponse("Not found", -30);
    ApiResponse ALREADY_EXISTS = new ApiResponse(" already exist ", -30);
}
