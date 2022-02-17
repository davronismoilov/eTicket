package uz.ticket.eticket.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.service.TicketService;

@RestController
@RequestMapping("/api/ticket")
//@RequiredArgsConstructor
public class TicketController {
    final  TicketService ticketService;


    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<?> getTicketList(){
        return ResponseEntity.ok(ticketService.getTicketListService());
    }


    public ResponseEntity<?> addTicket(){
        return ResponseEntity.ok(ticketService.getTicketList());
    }
    public ResponseEntity<?> editTicket(){
        return ResponseEntity.ok(ticketService.getTicketList());
    }
    public ResponseEntity<?> deleteTicket(){
        return ResponseEntity.ok(ticketService.getTicketList());
    }
}
