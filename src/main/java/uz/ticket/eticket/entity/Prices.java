package uz.ticket.eticket.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.base.BaseEntity;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
@Entity
public class Prices extends BaseEntity {

    @Column
    int traffic_id;

    @Column
    int fromStation;

    @Column
    int toStation;

    @Column
    double distance;//km

}
