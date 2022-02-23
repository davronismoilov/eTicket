package uz.ticket.eticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.Ticket;
import uz.ticket.eticket.repository.TicketRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService  {

    TicketRepository ticketRepository;
    final
    BaseResponse baseResponse;

    @Autowired
    public TicketService(TicketRepository ticketRepository, BaseResponse baseResponse) {
        this.ticketRepository = ticketRepository;
        this.baseResponse = baseResponse;
    }

    public ApiResponse getTicketListService() {
        List<Ticket> ticketList = ticketRepository.findAll();
        ApiResponse s = baseResponse.SUCCESS;
        s.setData(ticketList);
        return s;
    }

    public ApiResponse addTicketService(Ticket ticket) {
//        Ticket ticket = new Ticket();
        Ticket save = ticketRepository.save(ticket);
        ApiResponse success = baseResponse.SUCCESS;
        success.setData(ticket);
        return success;
    }

    public ApiResponse editTicketService(Ticket ticket) {
        Optional<Ticket> ticketbyId = ticketRepository.findById(ticket.getId());
        Ticket ticket1 = ticketbyId.get();

        return baseResponse.SUCCESS;
    }

    public ApiResponse deleteTicketService() {
        List<Ticket> ticketList = ticketRepository.findAll();
        ApiResponse success = baseResponse.SUCCESS;
        success.setData(ticketList);
        return success;
    }
}
