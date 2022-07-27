package sagengaliyev.project.booking.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sagengaliyev.project.booking.dto.UserDTO;
import sagengaliyev.project.booking.mapper.UserMapper;
import sagengaliyev.project.booking.model.Flat;
import sagengaliyev.project.booking.model.User;
import sagengaliyev.project.booking.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND="user with email %s not found";
    private final UserRepository userRepository;

    private final UserMapper userMapper;



    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
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
