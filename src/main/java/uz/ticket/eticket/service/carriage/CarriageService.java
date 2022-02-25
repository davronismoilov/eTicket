package uz.ticket.eticket.service.carriage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.carriage.Carriage;
import uz.ticket.eticket.repository.carriage.CarriageRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

import java.util.List;
import java.util.Optional;

@Service
public class CarriageService  {
    final
    CarriageRepository carriageRepository;
    final
    BaseResponse baseResponse;

    public CarriageService(CarriageRepository carriageRepository, BaseResponse baseResponse) {
        this.carriageRepository = carriageRepository;
        this.baseResponse = baseResponse;
    }


    public ApiResponse getCarriagetList() {
        List<Carriage> carriageList = carriageRepository.findAll();
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(carriageList);
        return SUCCESS;
    }

    public ApiResponse addCarriage(Carriage carriage) {
        Carriage saveCarriage = carriageRepository.save(carriage);
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(saveCarriage);
        return SUCCESS;
    }

    public ApiResponse deleteCarriage(Long id) {
        carriageRepository.deleteById(id);
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        return SUCCESS;
    }

    public ApiResponse updateCarriage(Long id, Carriage carriage) {
        deleteCarriage(id);
        Carriage carriage1 = carriageRepository.save(carriage);
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(carriage1);
        return SUCCESS;
    }

    public ApiResponse getByIdCarriage(Long id) {
        Optional<Carriage> carriagebyId = carriageRepository.findById(id);
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        carriagebyId.ifPresent(SUCCESS::setData);
        return SUCCESS;
    }


}
