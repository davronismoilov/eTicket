package uz.ticket.eticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import uz.ticket.eticket.repository.TrainRepository;
import uz.ticket.eticket.response.BaseResponse;

public class TrainService implements BaseResponse {

    @Autowired
    TrainRepository trainRepository;

}
