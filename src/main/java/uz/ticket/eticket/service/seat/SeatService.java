package uz.ticket.eticket.service.seat;

import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.seat.Seat;
import uz.ticket.eticket.repository.seat.SeatRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

@Service

public class SeatService {
    final
    SeatRepository seatRepository;
    BaseResponse baseResponse;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }


    public ApiResponse updateSeat(Seat seat) {
        Seat save = seatRepository.save(seat);
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(save);
        return SUCCESS;
    }


}
