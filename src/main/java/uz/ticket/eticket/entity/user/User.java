package uz.ticket.eticket.entity.user;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.user.Role;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(unique = true , nullable = false)
    String email;

    @Column(unique = true , nullable = false)
    String phoneNumber;


    @Column(nullable = false)
    String password;

    @ManyToOne
    Role role;

}
