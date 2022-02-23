package uz.ticket.eticket.entity;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(unique = true, nullable = false)
    String name;

    public Location(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Location() {
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
