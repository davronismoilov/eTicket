package uz.ticket.eticket.service.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.seat.Seat;
import uz.ticket.eticket.repository.seat.SeatRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

@Service

public class SeatService implements BaseResponse {
    final
    SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }


    public ApiResponse updateSeat(Long id, Seat seat) {

        return SUCCESS;
    }


}
