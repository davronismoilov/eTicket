package uz.ticket.eticket.service.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.repository.seat.SeatRepository;

@Service

public class SeatService {
    @Autowired
    SeatRepository seatRepository;



}
