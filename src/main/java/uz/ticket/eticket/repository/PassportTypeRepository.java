package uz.ticket.eticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.PassportType;

@Component
public interface PassportTypeRepository extends JpaRepository<PassportType, Long> {
}
