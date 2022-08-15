package sagengaliyev.project.booking.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import sagengaliyev.project.booking.dto.UserDTO;
import sagengaliyev.project.booking.model.User;

@Component
public class UserMapper {


    private final BCryptPasswordEncoder encoder;
    private final FlatMapper flatMapper;

    public UserMapper(BCryptPasswordEncoder encoder, FlatMapper flatMapper) {
        this.encoder = encoder;
        this.flatMapper = flatMapper;
    }


    public UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(encoder.encode(user.getPassword()));
        return userDTO;
    }

    public User toEntity(UserDTO userDTO){
       User user = new User();
       user.setId(userDTO.getId());
       user.setName(userDTO.getName());
       user.setEmail(userDTO.getEmail());
       user.setPassword(encoder.encode(userDTO.getPassword()));
       return user;
    }

    public User toEntityFromId(Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }
}
