package uz.ticket.eticket.repository.carriage;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.entity.carriage.Carriage;

import java.util.Optional;

public interface CarriageRepository extends JpaRepository<Carriage, Long> {
    Optional<Carriage> getCarriageByTrainId(long l);
}
