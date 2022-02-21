package uz.ticket.eticket.controller.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ticket.eticket.entity.seat.Seat;
import uz.ticket.eticket.service.seat.SeatService;

@RestController
@RequestMapping("/api/seat/")
public class SeatController {
    @Autowired
    SeatService seatservice;

    @PutMapping(value = "update")
    public ResponseEntity<?> updateSeat(
            @RequestBody Seat seat,
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(seatservice.updateSeat(id, seat));
    }


}
