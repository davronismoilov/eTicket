package uz.ticket.eticket.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.service.user.PassportTypeService;

@RestController
@RequestMapping("/api/passport/type")
public class PassportTypeController {

    final PassportTypeService passportTypeService;

    @Autowired
    public PassportTypeController( PassportTypeService passportTypeService) {
        this.passportTypeService = passportTypeService;
    }


    // get all passport types
    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllList() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(passportTypeService.getAllType());
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
