package uz.ticket.eticket.repository.train;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.entity.train.Train;

import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train, Long> {
    Optional<Train> findByCode(String code);
}
