package uz.ticket.eticket.service.train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.train.Train;
import uz.ticket.eticket.repository.train.TrainRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

import java.util.Optional;


@Service
public class TrainService {
    final
    TrainRepository trainRepository;

    final
    BaseResponse baseResponse;

    public TrainService(BaseResponse baseResponse, TrainRepository trainRepository) {
        this.baseResponse = baseResponse;
        this.trainRepository = trainRepository;
    }

    public ApiResponse save(Train train) {
        Train saveTrain = trainRepository.save(train);
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(saveTrain);
        return SUCCESS;
    }

    public ApiResponse findById(Long id) {
        Optional<Train> trainOptional = trainRepository.findById(id);
        Train train = null;
        if (trainOptional.isPresent()) {
            train = trainOptional.get();
        }
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(train);
        return SUCCESS;
    }

    public ApiResponse saveaa(Train train) {
        Train saveTrain = trainRepository.save(train);
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(saveTrain);
        return SUCCESS;
    }

    public ApiResponse findAll() {
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(trainRepository.findAll());
        return SUCCESS;
    }

    public ApiResponse update(Long id, Train train) {
        delete(id);
        ApiResponse save = save(train);
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(save);
        return SUCCESS;
    }

    public ApiResponse delete(Long id) {
        trainRepository.deleteById(id);
        return baseResponse.getSUCCESS();


    }
}
