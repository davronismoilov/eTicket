package uz.ticket.eticket.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.controller.user.entity.user.Passenger;

@Component
public interface PassengerRepository extends JpaRepository<Passenger , Long> {

}
