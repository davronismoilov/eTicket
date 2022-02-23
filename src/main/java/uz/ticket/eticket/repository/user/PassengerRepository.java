package uz.ticket.eticket.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.user.Passenger;

@Component
public interface PassengerRepository extends JpaRepository<Passenger , Long> {

}
