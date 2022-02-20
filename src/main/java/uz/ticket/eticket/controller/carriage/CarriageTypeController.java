package uz.ticket.eticket.controller.carriage;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ticket.eticket.service.carriage.CarriageTypeService;

@RestController
@RequestMapping("/api/carriage_type/")
public class CarriageTypeController {
    CarriageTypeService carriageTypeService;

    @Autowired
    public CarriageTypeController(CarriageTypeService carriageTypeService) {
        this.carriageTypeService = carriageTypeService;
    }



    @GetMapping("list")
    public ResponseEntity<?> getCarriageType() {
        return ResponseEntity.ok(carriageTypeService.getCarriageTypeList());
    }
}
