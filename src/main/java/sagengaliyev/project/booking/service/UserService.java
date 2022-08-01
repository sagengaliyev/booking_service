package sagengaliyev.project.booking.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import sagengaliyev.project.booking.dto.UserDTO;
import sagengaliyev.project.booking.mapper.UserMapper;
import sagengaliyev.project.booking.model.Flat;
import sagengaliyev.project.booking.model.User;
import sagengaliyev.project.booking.repository.UserRepository;

import java.util.List;

@Service

public class UserService  {

    private final UserRepository userRepository;

    private final UserMapper userMapper;



    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    public List<User> getUsers()
    {
        return null;
    }


    public String register(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        userRepository.save(user);
        return "You've successfully been registered!";
    }


}
