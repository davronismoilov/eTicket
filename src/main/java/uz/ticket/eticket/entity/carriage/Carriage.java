package uz.ticket.eticket.entity.carriage;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import uz.ticket.eticket.entity.base.BaseEntity;
import uz.ticket.eticket.entity.seat.Seat;

import javax.persistence.*;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Carriage extends BaseEntity {

    long trainId;

    @ManyToOne
    CarriageType carriageType;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Seat> seats;


}
