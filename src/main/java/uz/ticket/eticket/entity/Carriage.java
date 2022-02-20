package uz.ticket.eticket.entity;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

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

    int number;


}
