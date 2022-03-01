package uz.ticket.eticket.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.ticket.eticket.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route extends BaseEntity {

    @Column
    int traffic_id;

    @Column
    int orders;

    @Column
    int station_id;

}
