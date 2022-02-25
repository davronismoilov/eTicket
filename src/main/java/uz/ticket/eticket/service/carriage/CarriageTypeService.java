package uz.ticket.eticket.service.carriage;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.carriage.CarriageType;
import uz.ticket.eticket.repository.carriage.CarriageTypeRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

import java.util.List;



@Service
public class CarriageTypeService {
final
CarriageTypeRepository carriageTypeRepository;

    public CarriageTypeService(CarriageTypeRepository carriageTypeRepository) {
        this.carriageTypeRepository = carriageTypeRepository;
    }

    public ApiResponse getCarriageTypeList(){
        List<CarriageType> carriageTypes = carriageTypeRepository.findAll();
        ApiResponse SUCCESS = new BaseResponse().getSUCCESS();
        SUCCESS.setData(carriageTypes);
        return SUCCESS;
    }

}
