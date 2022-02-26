package uz.ticket.eticket.entity.user;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique = true , nullable = false)
    String username;

    @Column(nullable = false)
    String password;

    @ManyToMany
    Set<Role> role;

}
