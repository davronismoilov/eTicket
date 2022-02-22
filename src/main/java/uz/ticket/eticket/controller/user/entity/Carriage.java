package uz.ticket.eticket.controller.user.entity;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;

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

    int number;


}
