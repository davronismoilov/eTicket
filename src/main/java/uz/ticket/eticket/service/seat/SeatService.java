package uz.ticket.eticket.service.seat;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.seat.Seat;
import uz.ticket.eticket.payload.SeatDto;
import uz.ticket.eticket.repository.SeatRepository;
import uz.ticket.eticket.response.ApiResponse;

@Service

public class SeatService {


    private final SeatRepository seatRepository;
    private final ModelMapper  modelMapper;
    @Autowired
    public SeatService(SeatRepository seatRepository, ModelMapper modelMapper) {
        this.seatRepository = seatRepository;

        this.modelMapper = modelMapper;
    }

    public ApiResponse addSeat(SeatDto seatDto){

        Seat seat = modelMapper.map(seatDto, Seat.class);
        seatRepository.save(seat);


    }
}
