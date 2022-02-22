package uz.ticket.eticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.controller.user.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
