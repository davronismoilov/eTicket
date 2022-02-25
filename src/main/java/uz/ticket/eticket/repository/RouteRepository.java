package uz.ticket.eticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.ticket.eticket.entity.Route;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route,Integer> {

    @Query("select r from Route r where r.traffic_id = ?1 and r.station_id = ?2 and r.orders = ?3")
    Optional<Route> findByTraffic_idAndStation_idAndOrders(int traffic_id, int station_id, int orders);


    @Query("select r from Route r where r.traffic_id = ?1")
    List<Route> findByTraffic_id(int traffic_id);

    @Query("select r1.traffic_id\n" +
            "from Route r1, Route r2\n" +
            "where r1.traffic_id = r2.traffic_id\n" +
            "and r1.station_id =?1 \n" +
            "and r2.station_id =?2 \n" +
            "and r1.orders < r2.orders")
    List<Integer> findTrafficsByStation_id(int from_station , int to_station);



}
