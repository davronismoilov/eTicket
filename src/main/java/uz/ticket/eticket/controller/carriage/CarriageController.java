package uz.ticket.eticket.controller.carriage;

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
    public ResponseEntity<?> addCarriage(@PathVariable long trainId, @RequestBody Carriage carriage) {
        return carriageService.addCarriage(trainId, carriage);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateCarriage(@RequestBody Carriage carriage, @PathVariable long id) {
        return carriageService.updateCarriage(carriage, id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteCarriage(@PathVariable long id) {
        return carriageService.deleteCarriage(id);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getByIdCarriage(@PathVariable long id) {
        return carriageService.getCarriageById(id);
    }
}
