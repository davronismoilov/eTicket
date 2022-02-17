package uz.ticket.eticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.entity.CarriageType;

public interface CarriageTypeRepository extends JpaRepository<CarriageType, Long> {
}
