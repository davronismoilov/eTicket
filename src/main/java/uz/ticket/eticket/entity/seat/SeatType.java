package uz.ticket.eticket.entity.seat;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
@Entity
public class SeatType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(unique = true, nullable = false)
    String name;






    public SeatType(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SeatType() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
