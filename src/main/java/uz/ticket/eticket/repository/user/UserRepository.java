package uz.ticket.eticket.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.user.User;


import java.util.Optional;


@Component
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String userName);


}

