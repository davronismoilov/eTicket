package uz.ticket.eticket.controller.train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ticket.eticket.controller.user.entity.train.Train;
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

    @PostMapping(value = "update")
    public ResponseEntity<?> updateTrain(@RequestBody Train train, @PathVariable Long id) {
        return ResponseEntity.ok(trainService.update(id, train));
    }

    @PostMapping(value = "delete")
    public ResponseEntity<?> deleteTrain(@RequestBody Long id) {
        return ResponseEntity.ok(trainService.delete(id));
    }

    @GetMapping(value = "findById")
    public ResponseEntity<?> getTrainById(@PathVariable Long id) {
        return ResponseEntity.ok(trainService.findById(id));
    }

    @GetMapping(value = "findAll")
    public ResponseEntity<?> getTrainList() {
        return ResponseEntity.ok(trainService.findAll());
    }

}
