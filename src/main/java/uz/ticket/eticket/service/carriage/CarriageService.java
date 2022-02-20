package uz.ticket.eticket.service.carriage;

import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.carriage.Carriage;
import uz.ticket.eticket.repository.carriage.CarriageRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

import java.util.List;
import java.util.Optional;

@Service
public class CarriageService implements BaseResponse {
    final
    CarriageRepository carriageRepository;


    public CarriageService(CarriageRepository carriageRepository) {
        this.carriageRepository = carriageRepository;
    }


    public ApiResponse getCarriagetList() {
        List<Carriage> carriageList = carriageRepository.findAll();
        SUCCESS.setData(carriageList);
        return SUCCESS;
    }

    public ApiResponse addCarriage(Carriage carriage) {
        Carriage saveCarriage = carriageRepository.save(carriage);
        SUCCESS.setData(saveCarriage);
        return SUCCESS;
    }

    public ApiResponse deleteCarriage(Long id) {
        carriageRepository.deleteById(id);
        return SUCCESS;
    }

    public ApiResponse updateCarriage(Long id, Carriage carriage) {
        deleteCarriage(id);
        Carriage carriage1 = carriageRepository.save(carriage);
        SUCCESS.setData(carriage1);
        return SUCCESS;
    }

    public ApiResponse getByIdCarriage(Long id) {
        Optional<Carriage> carriagebyId = carriageRepository.findById(id);
        carriagebyId.ifPresent(SUCCESS::setData);
        return SUCCESS;
    }


}
