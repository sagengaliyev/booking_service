package sagengaliyev.project.booking.service;

import org.springframework.stereotype.Service;
import sagengaliyev.project.booking.dto.BookingDTO;
import sagengaliyev.project.booking.dto.ItemDTO;
import sagengaliyev.project.booking.mapper.ItemMapper;
import sagengaliyev.project.booking.mapper.UserMapper;
import sagengaliyev.project.booking.model.Item;
import sagengaliyev.project.booking.model.User;
import sagengaliyev.project.booking.repository.ItemRepository;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;
    private final UserService userService;
    private final UserMapper userMapper;

    private final BookingService bookingService;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper, UserService userService, UserMapper userMapper, BookingService bookingService) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.userService = userService;
        this.userMapper = userMapper;
        this.bookingService = bookingService;
    }

    public List<ItemDTO> getItems() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper::toDTO)
                .collect(Collectors.toList());
    }


    public String add(ItemDTO itemDTO, Principal principal) {
        Item item = itemMapper.toEntity(itemDTO);
        LocalDate date = LocalDate.now();
        item.setPublishDate(date);
        User user = userService.findByEmail(principal.getName()).orElseThrow(() -> new RuntimeException("unable to find user by username: " + principal.getName()));
        Long id = user.getId();
        item.getUser().setId(id);
        itemRepository.save(item);
        return "You've successfully added your flat item!";
    }

    public Optional<Item> showById(long id) {
        Optional<Item> items = itemRepository.findById(id);
        return items;
    }

    public String getItemById(long id){
        String item = itemRepository.getItemById(id);
        return item;
    }

    public void bookItem(Long id, BookingDTO bookingDTO,Principal principal){
        bookingService.book(id, bookingDTO, principal);
    }
}
