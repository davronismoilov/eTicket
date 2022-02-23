package uz.ticket.eticket.repository.train;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.entity.train.Train;

public interface TrainRepository extends JpaRepository<Train, Long> {
}
