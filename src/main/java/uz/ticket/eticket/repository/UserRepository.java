package uz.ticket.eticket.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.User;


@Component
public interface UserRepository extends CrudRepository<User , Long> {

    @Query("SELECT u FROM User u WHERE u.password = :password and u.email = :email")
    User findUserByEmailAnAndPasswordParams(
            @Param("password") String  password,
            @Param("email") String email);


}
