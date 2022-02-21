package uz.ticket.eticket.controller.carriage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ticket.eticket.entity.carriage.Carriage;
import uz.ticket.eticket.service.carriage.CarriageService;


@RestController
public class CarriageController {
    public final CarriageService carriageService;

    public CarriageController(CarriageService carriageService) {
        this.carriageService = carriageService;
    }

    @GetMapping("findAll")
    public ResponseEntity<?> getCarriage() {
        return ResponseEntity.ok(carriageService.getCarriagetList());
    }

    @PostMapping("save")
    public ResponseEntity<?> addCarriage(@RequestBody Carriage carriage) {
        return ResponseEntity.ok(carriageService.addCarriage(carriage));
    }

    @PutMapping("update")
    public ResponseEntity<?> updateCarriage(@RequestBody Carriage carriage, @PathVariable Long id) {
        return ResponseEntity.ok(carriageService.updateCarriage(id, carriage));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteCarriage(@PathVariable Long id) {
        return ResponseEntity.ok(carriageService.deleteCarriage(id));
    }

    @GetMapping("getById")
    public ResponseEntity<?> getByIdCarriage(@PathVariable Long id) {
        return ResponseEntity.ok(carriageService.getByIdCarriage(id));
    }
}
