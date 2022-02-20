package uz.ticket.eticket.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true)
    int code;

    @Column
    int capacity;

    @OneToMany
    List<TicketType> ticketTypes;
}
