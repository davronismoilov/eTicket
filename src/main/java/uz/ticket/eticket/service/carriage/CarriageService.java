package uz.ticket.eticket.service.carriage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.carriage.Carriage;
import uz.ticket.eticket.repository.carriage.CarriageRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

import java.util.List;
import java.util.Optional;

@Service
public class CarriageService {
    final CarriageRepository carriageRepository;
    final BaseResponse baseResponse;

    public CarriageService(CarriageRepository carriageRepository, BaseResponse baseResponse) {
        this.carriageRepository = carriageRepository;
        this.baseResponse = baseResponse;
    }


    public ResponseEntity<?> getCarriagetList() {
        List<Carriage> carriageList = carriageRepository.findAll();
        if (carriageList.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(baseResponse.getNOT_FOUND());
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(carriageList);
        return ResponseEntity.ok(SUCCESS);
    }

    public ResponseEntity<?> addCarriage(long trainId, Carriage carriage) {
        Optional<Carriage> carriageByTrainId = carriageRepository.findCarriageByTrainId(trainId);
        if (carriageByTrainId.isPresent())
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(baseResponse.getALREADY_EXISTS());
        Carriage save = carriageRepository.save(carriage);
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(save);
        return ResponseEntity.ok(SUCCESS);
    }

    public ResponseEntity<?> deleteCarriage(Long id) {

        Optional<Carriage> byId = carriageRepository.findById(id);
        if (byId.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(baseResponse.getUSER_NOT_FOUND());
        Carriage carriage = byId.get();
        carriage.setActive(false);
        Carriage save = carriageRepository.save(carriage);
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(save);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(SUCCESS);
    }

    public ResponseEntity<?> updateCarriage(Carriage carriage) {
        Carriage save = carriageRepository.save(carriage);
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(save);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(SUCCESS);
    }

    public ResponseEntity<?> getByIdCarriage(Long id) {
        Optional<Carriage> carriagebyId = carriageRepository.findById(id);
        if (carriagebyId.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(baseResponse.getUSER_NOT_FOUND());
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(carriagebyId.get());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(SUCCESS);
    }


}
