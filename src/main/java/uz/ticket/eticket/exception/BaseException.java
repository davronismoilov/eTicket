package uz.ticket.eticket.exception;

import uz.ticket.eticket.response.BaseResponse;

public class BaseException  extends  Exception{
    public BaseException(String message) {
        super("User Already exist");
    }
}
