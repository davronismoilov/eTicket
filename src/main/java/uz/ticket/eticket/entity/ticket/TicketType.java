package uz.ticket.eticket.entity.ticket;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.base.BaseEntity;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
@Entity
public class TicketType {



    @Column(unique = true, nullable = false)
    String name;
}

