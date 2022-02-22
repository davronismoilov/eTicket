package uz.ticket.eticket.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.controller.user.entity.user.User;


import java.util.Optional;


@Component
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByEmailOrPhoneNumber(String email, String phoneNumber);

    Optional<User> findByEmail(String email);

    Boolean existsByUsername(String email);

    Boolean existsByPhone(String phoneNumber);


}


/**
 * traffic
 * <p>
 * id        1
 * name      tosh-bux
 * date      12/23/2021
 * train_id   2
 * <p>
 * <p>
 * station
 * id       1       3      4        5
 * name     tosh     jiz   sir      bux
 * <p>
 * <p>
 * traffic_city
 * <p>
 * id
 * traffic_id  1
 * station_id  2
 * time        23.30
 * date         12/23
 */
