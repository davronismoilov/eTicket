package uz.ticket.eticket.service.train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.train.Train;
import uz.ticket.eticket.repository.train.TrainRepository;
import uz.ticket.eticket.response.ApiResponse;

import java.util.Optional;

import static uz.ticket.eticket.response.BaseResponse.SUCCESS;

@Service
public class TrainService {
    @Autowired
    TrainRepository trainRepository;

    public ApiResponse save(Train train) {
        Train saveTrain = trainRepository.save(train);
        SUCCESS.setData(saveTrain);
        return SUCCESS;
    }

    public ApiResponse findById(Long id) {
        Optional<Train> trainOptional = trainRepository.findById(id);
        Train train = null;
        if (trainOptional.isPresent()) {
            train = trainOptional.get();
        }
        SUCCESS.setData(train);
        return SUCCESS;
    }

    public ApiResponse saveaa(Train train) {
        Train saveTrain = trainRepository.save(train);
        SUCCESS.setData(saveTrain);
        return SUCCESS;
    }
}
