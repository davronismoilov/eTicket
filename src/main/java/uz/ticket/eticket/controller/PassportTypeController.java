package uz.ticket.eticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.ticket.eticket.entity.PassportType;
import uz.ticket.eticket.repository.PassportTypeRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.service.PassportTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passport_type")
public class PassportTypeController {
    final
    PassportTypeRepository passportTypeRepository;

    final PassportTypeService passportTypeService;


    @Autowired
    public PassportTypeController(PassportTypeRepository passportTypeRepository, PassportTypeService passportTypeService) {
        this.passportTypeRepository = passportTypeRepository;
        this.passportTypeService = passportTypeService;
    }


    // get all passport types
    @GetMapping(value = "/all_list")
    public ApiResponse getAllList() {
        return passportTypeService.getAllType();
    }


    // get one by id
    @GetMapping(value = "/get/{id}")
    public ApiResponse getTypeById(@PathVariable("id") Long id) {
        return passportTypeService.getById(id);
    }

    // edit passport type by id
    @PutMapping(value = "/edit/{id}")
    public ApiResponse getEditType(@PathVariable("id") Long id, @RequestBody String name) {
        return passportTypeService.editById(id, name);
    }


    // delete passport type by id
    @DeleteMapping(value = "/delete/{id}")
    public ApiResponse deleteTypeById(@PathVariable("id") Long id) {
        return passportTypeService.deleteById(id);
    }

    //add passport type
    @PostMapping(value = "/add/{name}")
    public ApiResponse addType(@PathVariable("name") String name) {
        return passportTypeService.add(name);
    }


}
