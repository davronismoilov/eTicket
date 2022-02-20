package uz.ticket.eticket.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
@Entity
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    int traffic_id;

    @Column
    int fromStation;

    @Column
    int toStation;

    @Column
    double distance;//km

}
