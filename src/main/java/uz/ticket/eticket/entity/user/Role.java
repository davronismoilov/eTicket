package uz.ticket.eticket.entity.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.base.BaseEntity;


import javax.persistence.*;

@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
@Entity
public class Role extends BaseEntity {


    @Column(unique = true, nullable = false)
    String name;

    public Role(String name) {
        this.name = name;
    }
}
