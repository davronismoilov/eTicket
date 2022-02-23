package uz.ticket.eticket.repository.carriage;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.entity.carriage.CarriageType;

public interface CarriageTypeRepository extends JpaRepository<CarriageType, Long> {
}
