package uz.ticket.eticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.entity.Carriage;

public interface CarriageRepository extends JpaRepository<Carriage, Long> {
}
