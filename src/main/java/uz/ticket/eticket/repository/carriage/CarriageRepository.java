package uz.ticket.eticket.repository.carriage;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.entity.carriage.Carriage;

public interface CarriageRepository extends JpaRepository<Carriage, Long> {
}
