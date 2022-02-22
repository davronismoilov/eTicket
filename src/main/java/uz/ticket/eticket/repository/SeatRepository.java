package uz.ticket.eticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.controller.user.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
