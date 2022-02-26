package uz.ticket.eticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ticket.eticket.repository.carriage.CarriageRepository;
import uz.ticket.eticket.service.ticket.TicketService;


@RestController
@RequestMapping("/api/ticket")
//@RequiredArgsConstructor
public class TicketController {
    final TicketService ticketService;
    final
    CarriageRepository carriageRepository;


    @Autowired
    public TicketController(TicketService ticketService, CarriageRepository carriageRepository) {
        this.ticketService = ticketService;
        this.carriageRepository = carriageRepository;
    }

    public ResponseEntity<?> getTicketList() {
        return ResponseEntity.ok(ticketService.getTicketListService());
    }

//
//    public ResponseEntity<?> addTicket(){
//        return ResponseEntity.ok(ticketService.getTicketList());
//    }
//    public ResponseEntity<?> editTicket(){
//        return ResponseEntity.ok(ticketService.getTicketList());
//    }
//    public ResponseEntity<?> deleteTicket(){
//        return ResponseEntity.ok(ticketService.getTicketList());
//    }

    @GetMapping(value = "/111")
    public Object getSeat(){
       return carriageRepository.getCarriageByTrainId(1L);
    }


}
