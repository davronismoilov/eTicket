package uz.ticket.eticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import uz.ticket.eticket.entity.Route;
import uz.ticket.eticket.repository.RouteRepository;
import uz.ticket.eticket.repository.StationRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService  {

    private final RouteRepository routeRepository;
    final
    BaseResponse  baseResponse;

    public RouteService(RouteRepository routeRepository, BaseResponse baseResponse) {
        this.routeRepository = routeRepository;
        this.baseResponse = baseResponse;
    }

    public ApiResponse getAllRoutes(){
        List<Route> all = routeRepository.findAll();
        System.out.println(all.size());
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(all);
        return SUCCESS;
    }

    public ApiResponse getRoute(int id){
        Optional<Route> routeOptional = routeRepository.findById(id);
        if(routeOptional.isPresent()){
            ApiResponse SUCCESS = baseResponse.getSUCCESS();
            SUCCESS.setData(routeOptional.get());
            return SUCCESS;
        }
        ApiResponse UNSUCCESS = baseResponse.getSUCCESS();
        UNSUCCESS.setData(new Route());
        return UNSUCCESS;
    }

    public ApiResponse addRoute(Route route){
        routeRepository.save(route);
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(true);
        return SUCCESS;
    }

    public ApiResponse editRoute(int traffic_id, Route route){
        Optional<Route> routeOptional = routeRepository.findByTraffic_idAndStation_idAndOrders(
                traffic_id, route.getStation_id(),route.getOrders());

        if (routeOptional.isPresent()){
            Route routeOld = routeOptional.get();

            if (route.getStation_id() != 0)
                routeOld.setStation_id(route.getStation_id());

            if (route.getOrders() != 0)
                routeOld.setOrders(route.getOrders());

            routeRepository.save(routeOld);
            ApiResponse SUCCESS = baseResponse.getSUCCESS();
            SUCCESS.setData(true);
            return SUCCESS;
        }
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(false);
        return SUCCESS;
    }

    public ApiResponse getTrafficsbyStations(int from_station, int to_station){
        ApiResponse SUCCESS = baseResponse.getSUCCESS();
        SUCCESS.setData(routeRepository.findTrafficsByStation_id(from_station,to_station));
        return SUCCESS;
    }

}
