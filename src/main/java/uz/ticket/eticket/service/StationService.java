package uz.ticket.eticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.Station;
import uz.ticket.eticket.repository.StationRepository;
import uz.ticket.eticket.response.ApiResponse;
import uz.ticket.eticket.response.BaseResponse;

import java.util.List;
import java.util.Optional;

@Service
public class StationService implements BaseResponse {

    @Autowired
    private StationRepository stationRepository;

    public ApiResponse getAllStations(){
        List<Station> all = stationRepository.findAll();
        System.out.println(all.size());
        SUCCESS.setData(all);
       return SUCCESS;
    }

    public ApiResponse getStation(int id){
        Optional<Station> stationOptional = stationRepository.findById(id);
        SUCCESS.setData(stationOptional.get());
        return SUCCESS;
    }

    public ApiResponse addStation(Station station){
        boolean existsByName = stationRepository.existsByName(station.getName());
        if (existsByName){
            ALREADY_EXISTS.setData(existsByName);
            return ALREADY_EXISTS;
        }
        stationRepository.save(station);
        SUCCESS.setData(!existsByName);
        return SUCCESS;
    }

    public ApiResponse editStation(int id, Station station){
        Optional<Station> stationOptional = stationRepository.findById(id);
        if (stationOptional.isPresent()){
            Station stationOld = stationOptional.get();
            if (station.getName() != null)
                stationOld.setName(station.getName());
            stationRepository.save(stationOld);
            SUCCESS.setData(true);
            return SUCCESS;
        }
        SUCCESS.setData(false);
        return SUCCESS;
    }

    public int getStationIdByName(String name){
        Optional<Station> stationOptional = stationRepository.getByName(name);

        if (stationOptional.isEmpty())
            return 0;

        return stationOptional.get().getId();
    }

}
