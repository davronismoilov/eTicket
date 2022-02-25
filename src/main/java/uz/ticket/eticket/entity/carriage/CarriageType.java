package uz.ticket.eticket.entity.carriage;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.base.BaseEntity;

import javax.persistence.Entity;

@Entity
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarriageType extends BaseEntity {


    String name;

}