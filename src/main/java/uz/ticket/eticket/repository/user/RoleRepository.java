package uz.ticket.eticket.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.entity.user.Role;

public interface RoleRepository extends JpaRepository<Role , Long> {
}
