package uz.ticket.eticket.service.seat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.seat.Seat;
import uz.ticket.eticket.repository.seat.SeatRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

import java.util.List;
import java.util.Optional;

@Service

public class SeatService {
    final
    SeatRepository seatRepository;
    BaseResponse baseResponse;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }


    public ResponseEntity<?> updateSeat(Seat seat, long id) {
        Optional<Seat> byId = seatRepository.findById(id);
        if (byId.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(baseResponse.getUSER_NOT_FOUND());
        seat.setId(id);
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(seat);
        return ResponseEntity.ok(SUCCESS);
    }


    public ResponseEntity<?> getSeatList() {
        List<Seat> all = seatRepository.findAll();
        if (all.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(baseResponse.getUSER_NOT_FOUND());
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(all);
        return ResponseEntity.ok(SUCCESS);
    }

    public ResponseEntity<?> addSeat(Seat seat) {
        Seat save = seatRepository.save(seat);
        ApiResponse success = baseResponse.getSUCCESS();
        success.setData(save);
        return ResponseEntity.ok(success);
    }

    public ResponseEntity<?> deleteSeat(long id) {
        Optional<Seat> byId = seatRepository.findById(id);
        if (byId.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(baseResponse.getUSER_NOT_FOUND());
        Seat seat = byId.get();
        seat.setActive(false);
        ApiResponse success = baseResponse.getSUCCESS();
        success.setData(seat);
        return ResponseEntity.ok(success);
    }

    public ResponseEntity<?> getSeatById(long id) {
        Optional<Seat> byId = seatRepository.findById(id);
        if (byId.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(baseResponse.getUSER_NOT_FOUND());
        ApiResponse success = baseResponse.getSUCCESS();
        success.setData(byId.get());
        return ResponseEntity.ok(success);
    }
}
