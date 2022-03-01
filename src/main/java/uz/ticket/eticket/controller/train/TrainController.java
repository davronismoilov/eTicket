package uz.ticket.eticket.controller.train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ticket.eticket.entity.train.Train;
import uz.ticket.eticket.service.train.TrainService;

@RestController
@RequestMapping("/api/train/")
public class TrainController {
    @Autowired
    TrainService trainService;

    // TODO: 19.02.2022 CRUD
    @PostMapping(value = "save")
    public ResponseEntity<?> addTrain(@RequestBody Train train) {
        return ResponseEntity.ok(trainService.save(train));
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<?> updateTrain(@RequestBody Train train, @PathVariable long id) {
        return ResponseEntity.ok(trainService.update(train, id));
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteTrain(@PathVariable long id) {
        return ResponseEntity.ok(trainService.delete(id));
    }

    @GetMapping(value = "findById/{id}")
    public ResponseEntity<?> getTrainById(@PathVariable long id) {
        return ResponseEntity.ok(trainService.findById(id));
    }

    @GetMapping(value = "findAll")
    public ResponseEntity<?> getTrainList() {
        return ResponseEntity.ok(trainService.findAll());
    }

}
