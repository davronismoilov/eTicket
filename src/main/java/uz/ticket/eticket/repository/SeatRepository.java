package uz.ticket.eticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
