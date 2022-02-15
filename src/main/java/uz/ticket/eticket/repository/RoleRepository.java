package uz.ticket.eticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ticket.eticket.entity.Role;

public interface RoleRepository extends JpaRepository<Role , Long> {
}
