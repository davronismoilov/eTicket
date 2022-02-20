package uz.ticket.eticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ticket.eticket.entity.Station;
import uz.ticket.eticket.service.StationService;

@RestController
@RequestMapping("/api/station")
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllStations(){
        return ResponseEntity.ok(stationService.getAllStations());
    }

    @GetMapping("/get")
    public ResponseEntity<?> getStation(@RequestParam int id){
        return ResponseEntity.ok(stationService.getStation(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStation(@RequestBody Station station){
       return ResponseEntity.ok(stationService.addStation(station));
    }

    @PutMapping("/edit")
    public ResponseEntity<?> addStation(@RequestParam int id,@RequestBody Station station){
        return ResponseEntity.ok(stationService.editStation(id,station));
    }

}
