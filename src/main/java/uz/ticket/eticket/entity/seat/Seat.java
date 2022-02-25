package uz.ticket.eticket.entity.seat;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.base.BaseEntity;

import javax.persistence.*;

@Entity
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Seat extends BaseEntity {

    boolean is_available = true;
    int seatNumber;
    @ManyToOne
    SeatType seatType;

}
