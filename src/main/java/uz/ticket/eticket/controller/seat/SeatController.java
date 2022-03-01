package uz.ticket.eticket.controller.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ticket.eticket.entity.carriage.Carriage;
import uz.ticket.eticket.entity.seat.Seat;
import uz.ticket.eticket.service.seat.SeatService;

@RestController
@RequestMapping("/api/seat/")
public class SeatController {
    @Autowired
    SeatService seatservice;

    @PutMapping(value = "update/{id}")
    public ResponseEntity<?> updateSeat(@RequestBody Seat seat, @PathVariable long id) {
        return ResponseEntity.ok(seatservice.updateSeat(seat, id));
    }

    @GetMapping("findAll")
    public ResponseEntity<?> getSeat() {
        return seatservice.getSeatList();
    }

    @PostMapping("save")
    public ResponseEntity<?> addSeat(@RequestBody Seat carriage) {
        return seatservice.addSeat(carriage);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteSeat(@PathVariable long id) {
        return seatservice.deleteSeat(id);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getSeatById(@PathVariable long id) {
        return seatservice.getSeatById(id);
    }

}
