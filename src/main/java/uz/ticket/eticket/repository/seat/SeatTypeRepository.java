package uz.ticket.eticket.repository.seat;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.entity.seat.SeatType;

public interface SeatTypeRepository extends JpaRepository<SeatType, Long> {
}
