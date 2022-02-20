package uz.ticket.eticket.controller.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ticket.eticket.entity.ticket.Ticket;
import uz.ticket.eticket.service.ticket.TicketService;

@RestController
@RequestMapping("/api/ticket")
//@RequiredArgsConstructor
public class TicketController {
    final TicketService ticketService;


    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<?> getTicketList() {
        return ResponseEntity.ok(ticketService.getTicketListService());
    }

    Ticket ticket = new Ticket();

    public ResponseEntity<?> addTicket() {
        return ResponseEntity.ok(ticketService.addTicketService(ticket));
    }

    public ResponseEntity<?> editTicket() {
        return ResponseEntity.ok(ticketService.editTicketService(ticket));
    }

    public ResponseEntity<?> deleteTicket() {
        return ResponseEntity.ok(ticketService.deleteTicketService());
    }
}
