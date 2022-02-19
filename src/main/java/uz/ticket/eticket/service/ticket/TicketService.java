package uz.ticket.eticket.service.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.ticket.Ticket;
import uz.ticket.eticket.repository.ticket.TicketRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements BaseResponse {

    TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public ApiResponse getTicketListService() {
        List<Ticket> ticketList = ticketRepository.findAll();
        SUCCESS.setData(ticketList);
        return SUCCESS;
    }

    public ApiResponse addTicketService(Ticket ticket) {
//        Ticket ticket = new Ticket();
        Ticket save = ticketRepository.save(ticket);
        SUCCESS.setData(ticket);
        return SUCCESS;
    }

    public ApiResponse editTicketService(Ticket ticket) {
        Optional<Ticket> ticketbyId = ticketRepository.findById(ticket.getId());
        Ticket ticket1 = ticketbyId.get();

        return SUCCESS;
    }

    public ApiResponse deleteTicketService() {
        List<Ticket> ticketList = ticketRepository.findAll();
        SUCCESS.setData(ticketList);
        return SUCCESS;
    }
}
