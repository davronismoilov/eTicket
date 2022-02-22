package uz.ticket.eticket.controller.user.entity;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Seat {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        long id;

        boolean is_available = true;

        int seatNumber;

        @ManyToOne
        Carriage carriage;
}
