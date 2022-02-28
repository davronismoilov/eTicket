package uz.ticket.eticket.controller.carriage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ticket.eticket.entity.carriage.Carriage;
import uz.ticket.eticket.service.carriage.CarriageService;


@RestController
@RequestMapping("/api/carriage/")
public class CarriageController {
    public final CarriageService carriageService;

    public CarriageController(CarriageService carriageService) {
        this.carriageService = carriageService;
    }

    @GetMapping("findAll")
    public ResponseEntity<?> getCarriage() {
        return carriageService.getCarriagetList();
    }

    @PostMapping("save")
    public ResponseEntity<?> addCarriage(@PathVariable long trainId,
                                         @RequestBody Carriage carriage) {
        return carriageService.addCarriage(trainId, carriage);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateCarriage(@RequestBody Carriage carriage) {
        return carriageService.updateCarriage(carriage);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteCarriage(@PathVariable Long id) {
        return carriageService.deleteCarriage(id);
    }

    @GetMapping("getById")
    public ResponseEntity<?> getByIdCarriage(@PathVariable Long id) {
        return carriageService.getByIdCarriage(id);
    }
}
