package uz.ticket.eticket.repository.seat;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.controller.user.entity.seat.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
