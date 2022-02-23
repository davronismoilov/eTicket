package uz.ticket.eticket.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import uz.ticket.eticket.entity.user.Role;
import uz.ticket.eticket.entity.user.User;
import uz.ticket.eticket.payload.UserDTO;
import uz.ticket.eticket.repository.user.RoleRepository;
import uz.ticket.eticket.repository.user.UserRepository;
import uz.ticket.eticket.response.ApiResponse;

import java.util.Set;

@Service
@Component
public class UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;


    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

    }

    public ApiResponse login(UserDTO user) {
        return null;

    }

    public ApiResponse register(UserDTO user) {
        User user1 = new User();
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        Role role = new Role();
        role.setName("Admin");
        roleRepository.save(role);
        user1.setRole((Set<Role>) role);



        userRepository.save(user1);
        return   new ApiResponse("Success", 0);


    }


}
