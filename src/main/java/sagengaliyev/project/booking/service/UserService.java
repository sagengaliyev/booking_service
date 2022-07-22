package sagengaliyev.project.booking.service;


import org.springframework.stereotype.Service;
import sagengaliyev.project.booking.dto.UserDTO;
import sagengaliyev.project.booking.mapper.UserMapper;
import sagengaliyev.project.booking.model.User;
import sagengaliyev.project.booking.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService(UserRepository userRepository,  UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    public List<User> getUsers()
    {
        return null;
    }






}
