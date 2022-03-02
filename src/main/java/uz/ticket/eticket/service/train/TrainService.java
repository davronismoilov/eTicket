package uz.ticket.eticket.service.train;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.train.Train;
import uz.ticket.eticket.repository.train.TrainRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

import java.util.List;
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

    public ResponseEntity<?> save(Train train) {
        Optional<Train> byCode = trainRepository.findByCode(train.getCode());
        if (byCode.isPresent())
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(baseResponse.getALREADY_EXISTS());
        Train saveTrain = trainRepository.save(train);
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(saveTrain);
        return ResponseEntity.ok().body(SUCCESS);
    }

    public ResponseEntity<?> findById(Long id) {
        Optional<Train> trainOptional = trainRepository.findById(id);
        if (trainOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(baseResponse.getUSER_NOT_FOUND());
        }
        Train train = trainOptional.get();
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(train);
        return ResponseEntity.ok(SUCCESS);
    }


    public ResponseEntity<?> findAll() {
        List<Train> all = trainRepository.findAll();
        if (all.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(baseResponse.getNOT_FOUND());
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(all);
        return ResponseEntity.ok().body(SUCCESS);
    }

    public ResponseEntity<?> update(Train train, long id) {
        Optional<Train> byId = trainRepository.findById(id);
        if (byId.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(baseResponse.getUSER_NOT_FOUND());
        train.setId(id);
        Train save = trainRepository.save(train);
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(save);
        return ResponseEntity.ok(SUCCESS);
    }

    public ResponseEntity<?> delete(Long id) {
        Optional<Train> byId = trainRepository.findById(id);
        if(byId.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(baseResponse.getNOT_FOUND());

        trainRepository.deleteById(id);
         ApiResponse success = baseResponse.getSUCCESS();

        return ResponseEntity.ok(success);


    }
}
