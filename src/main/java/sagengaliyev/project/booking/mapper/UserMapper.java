package sagengaliyev.project.booking.mapper;

import org.springframework.stereotype.Component;
import sagengaliyev.project.booking.dto.UserDTO;
import sagengaliyev.project.booking.model.Role;
import sagengaliyev.project.booking.model.User;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

@Component
public class UserMapper {
    public UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setRoles(user.getRoles());
        return userDTO;
    }

    public User toEntity(UserDTO userDTO){
       User user = new User();
       user.setId(userDTO.getId());
       user.setEmail(userDTO.getEmail());
       user.setPassword(userDTO.getPassword());
       user.setRoles(userDTO.getRoles());
       return user;
    }
}
