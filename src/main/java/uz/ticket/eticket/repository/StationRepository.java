package uz.ticket.eticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.ticket.eticket.entity.Station;

import java.util.Optional;

@Repository
public interface StationRepository extends JpaRepository<Station,Integer> {

    @Query("select (count(s) > 0) from Station s where s.name = ?1")
    boolean existsByName(String name);

    @Query("select s from Station s where s.name = ?1")
    Optional<Station> getByName(String id);
}