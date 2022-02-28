package uz.ticket.eticket.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.ticket.eticket.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station extends BaseEntity {


    @Column
    String name;


}
