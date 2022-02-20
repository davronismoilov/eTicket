package uz.ticket.eticket.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.user.PassportType;
import uz.ticket.eticket.repository.user.PassportTypeRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class PassportTypeService implements BaseResponse {

    final
    PassportTypeRepository passportTypeRepository;

    @Autowired
    public PassportTypeService(PassportTypeRepository passportTypeRepository) {
        this.passportTypeRepository = passportTypeRepository;

    }

    public ApiResponse getAllType() {
        List<PassportType> passportTypeList = passportTypeRepository.findAll();
        SUCCESS.setData(passportTypeList);
        return SUCCESS;
    }

    public ApiResponse getById(Long id) {
        Optional<PassportType> byId = passportTypeRepository.findById(id);
        if (byId.isPresent()) {
            SUCCESS.setData(byId.get());
            return SUCCESS;
        } else {
            return NOT_FOUND;
        }
    }


    public ApiResponse editById(Long id, String name) {
        Optional<PassportType> byId = passportTypeRepository.findById(id);
        if (byId.isPresent()) {
            PassportType passportType = byId.get();
            passportType.setName(name);
            passportTypeRepository.save(passportType);
            SUCCESS.setData(passportType);
            return SUCCESS;
        } else {
            return NOT_FOUND;
        }
    }

    public ApiResponse deleteById(Long id) {
        Optional<PassportType> byId = passportTypeRepository.findById(id);
        if (byId.isPresent()) {
            passportTypeRepository.deleteById(id);
            SUCCESS.setMessage("delete");
            SUCCESS.setData(null);
            return  SUCCESS;
        } else {
            return NOT_FOUND;
        }
    }

    public ApiResponse add(String name) {
        Optional<PassportType> byId = passportTypeRepository.findByName(name);
        if (!byId.isPresent()) {

            PassportType passportType = new PassportType();
            passportType.setName(name);
            passportTypeRepository.save(passportType);
            SUCCESS.setData(passportType);
            return SUCCESS;
        } else {
            return ALREADY_EXISTS;
        }

    }
}