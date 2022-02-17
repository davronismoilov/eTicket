package uz.ticket.eticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.Passenger;

@Component
public interface PassengerRepository extends JpaRepository<Passenger , Long> {

}
