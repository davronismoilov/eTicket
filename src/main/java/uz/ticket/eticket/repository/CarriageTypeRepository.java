package uz.ticket.eticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.controller.user.entity.CarriageType;

public interface CarriageTypeRepository extends JpaRepository<CarriageType, Long> {
}
