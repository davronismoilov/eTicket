package uz.ticket.eticket.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;
import uz.ticket.eticket.entity.user.Role;

import java.util.Set;


@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private String email;
    private String password;
    private String mobileNumber;
    private boolean isAdmin;
    private Set<Role> roles;

}
