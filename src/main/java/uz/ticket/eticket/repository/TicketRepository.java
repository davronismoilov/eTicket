package uz.ticket.eticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.entity.ticket.Ticket;


public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
