package uz.ticket.eticket.entity.seat;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
@Entity
public class SeatType extends BaseEntity {



    @Column(unique = true, nullable = false)
    String name;


    public SeatType() {
    }

    public SeatType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
