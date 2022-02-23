package uz.ticket.eticket.controller.seat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ticket.eticket.payload.SeatDto;

@RestController
@RequestMapping("/api/seat")
public class SeatController {
    // TODO: 19.02.2022 update

    @PutMapping("/add")
    public ResponseEntity<?> addSeat( @RequestBody SeatDto seatDto){


      return ResponseEntity.ok().body(new Object());
    }

}
