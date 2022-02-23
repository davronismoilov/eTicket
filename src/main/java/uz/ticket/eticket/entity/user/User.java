package uz.ticket.eticket.entity.user;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;


import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
@Entity
@Table(name = "users")
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(unique = true )
    String email;

    @Column(unique = true )
    String phoneNumber;


    @Column(nullable = false)
    String password;

    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    Set<Role> role = new HashSet<>(Arrays.asList(new Role(uz.ticket.eticket.enums.Role.USER.name())));

    public User() {

    }
}
