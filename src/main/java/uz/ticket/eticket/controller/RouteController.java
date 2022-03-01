package uz.ticket.eticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ticket.eticket.entity.Route;
import uz.ticket.eticket.service.RouteService;
import uz.ticket.eticket.service.StationService;

@RestController
@RequestMapping("/api/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private StationService stationService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllRoutes(){
        return ResponseEntity.ok(routeService.getAllRoutes());
    }

    @GetMapping("/get")
    public ResponseEntity<?> getRoute(@RequestParam int id){
        return ResponseEntity.ok(routeService.getRoute(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRoute(@RequestBody Route route){
        return ResponseEntity.ok(routeService.addRoute(route));
    }

    @PutMapping("/edit")
    public ResponseEntity<?> addRoute(@RequestParam int id,@RequestBody Route route){
        return ResponseEntity.ok(routeService.editRoute(id,route));
    }

    @PostMapping("/getTraffics")
    public ResponseEntity<?> getTrafficsByStations(@RequestParam("from_station") String from_station, @RequestParam("to_station") String to_station){
        long fromStation = stationService.getStationIdByName(from_station);
        long toStation = stationService.getStationIdByName(to_station);
        return ResponseEntity.ok(routeService.getTrafficsbyStations(fromStation,toStation));
    }
}
