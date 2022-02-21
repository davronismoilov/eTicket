package uz.ticket.eticket.entity.user;

import lombok.*;
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
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique = true , nullable = false)
    String email;

    @Column(unique = true , nullable = false)
    String phoneNumber;


    @Column(nullable = false)
    String password;

    @ManyToOne
    Role role;

}
