package uz.ticket.eticket.repository.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.entity.ticket.TicketType;


public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {
}
