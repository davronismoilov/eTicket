package uz.ticket.eticket.controller.user.entity.carriage;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.controller.user.entity.seat.Seat;

import javax.persistence.*;
import java.util.List;

@Entity
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Carriage {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    long id;
    long trainId;
    @ManyToOne
    CarriageType carriageType;
    @OneToMany
    List<Seat> seatList;



}
