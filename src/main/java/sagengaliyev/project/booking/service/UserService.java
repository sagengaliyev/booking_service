package sagengaliyev.project.booking.service;

import org.springframework.stereotype.Service;
import sagengaliyev.project.booking.dto.UserDTO;
import sagengaliyev.project.booking.mapper.UserMapper;
import sagengaliyev.project.booking.model.Item;
import sagengaliyev.project.booking.model.User;
import sagengaliyev.project.booking.repository.ItemRepository;
import sagengaliyev.project.booking.repository.UserRepository;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service

public class UserService  {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    private final UserMapper userMapper;



    public UserService(UserRepository userRepository, ItemRepository itemRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
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

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<Item> getItems(Principal principal){
        User user = findByEmail(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        Long userId = user.getId();
        return itemRepository.getItemByUserId(userId);

    }

}
