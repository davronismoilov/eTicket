package uz.ticket.eticket.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.user.PassportType;

import javax.websocket.server.PathParam;
import java.util.Optional;

@Component
public interface PassportTypeRepository extends JpaRepository<PassportType, Long> {
    Optional<PassportType> findByName(@PathParam("name") String name);
}
