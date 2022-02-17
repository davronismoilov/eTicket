package uz.ticket.eticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
