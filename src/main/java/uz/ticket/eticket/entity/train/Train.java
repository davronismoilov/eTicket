package uz.ticket.eticket.entity.train;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.ticket.eticket.entity.base.BaseEntity;

import javax.persistence.*;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Train extends BaseEntity {

    @Column(unique = true)
    String code;

    int capacity;
}
