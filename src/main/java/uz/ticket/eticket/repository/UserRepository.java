package uz.ticket.eticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.user.User;

import java.util.Optional;


@Component
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByEmailOrPhoneNumber(String email, String phoneNumber);

    Optional<User> findByEmail(String email);




}
