package uz.ticket.eticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.Carriage;

@Component
public interface CarriageRepository extends JpaRepository<Carriage, Long> {


    @Query(value = "select json_build_object(" +
            "  'carriage_number',  carriage.number,\n" +
            "    'joylar' ,  json_agg( s.seat_number))\n" +
            "from carriage\n" +
            "         inner join\n" +
            "     train t on t.id = carriage.train_id\n" +
            "         inner join seat s on carriage.id = s.carriage_id\n" +
            "where s.is_available = true\n" +
            "  and t.id = ?1 group by carriage.number;", nativeQuery = true)
    Object getCarriageByTrainId(Long id);


}
