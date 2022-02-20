package uz.ticket.eticket.controller.carriage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ticket.eticket.entity.carriage.Carriage;
import uz.ticket.eticket.service.carriage.CarriageService;


@RestController
public class CarriageController {
    @Autowired
    public CarriageService carriageService;

    @GetMapping("findAll")
    public ResponseEntity<?> getCarriage() {
        return ResponseEntity.ok(carriageService.getCarriagetList());
    }
    @PostMapping("save")
    public ResponseEntity<?> addCarriage(@RequestBody Carriage carriage) {
        return ResponseEntity.ok(carriageService.addCarriage(carriage));
    }
    @PostMapping("update")
    public ResponseEntity<?> updateCarriage(@RequestBody Carriage carriage, @PathVariable Long id) {
        return ResponseEntity.ok(carriageService.updateCarriage(id, carriage));
    }
    @PostMapping("delete")
    public ResponseEntity<?> deleteCarriage(@PathVariable Long id) {
        return ResponseEntity.ok(carriageService.deleteCarriage(id));
    }
    @PostMapping("getById")
    public ResponseEntity<?> getByIdCarriage(@PathVariable Long id) {
        return ResponseEntity.ok(carriageService.getByIdCarriage(id));
    }
}
