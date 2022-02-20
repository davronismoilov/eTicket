package uz.ticket.eticket.service.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.repository.seat.SeatTypeRepository;
import uz.ticket.eticket.response.ApiResponse;

@Service
public class SeatTypeService {

    @Autowired
    SeatTypeRepository seatTypeRepository;


}
