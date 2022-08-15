package sagengaliyev.project.booking.service;

import org.springframework.stereotype.Service;
import sagengaliyev.project.booking.dto.BookingDTO;
import sagengaliyev.project.booking.dto.ItemDTO;
import sagengaliyev.project.booking.mapper.BookingMapper;
import sagengaliyev.project.booking.model.Booking;
import sagengaliyev.project.booking.model.User;
import sagengaliyev.project.booking.repository.BookingRepository;
import sagengaliyev.project.booking.repository.ItemRepository;

import java.security.Principal;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final BookingMapper bookingMapper;
    private final ItemRepository itemRepository;
    public BookingService(BookingRepository bookingRepository, UserService userService, BookingMapper bookingMapper, ItemRepository itemRepository) {
        this.bookingRepository = bookingRepository;
        this.userService = userService;
        this.bookingMapper = bookingMapper;
        this.itemRepository = itemRepository;
    }
    public void book(Long id, BookingDTO bookingDTO, Principal principal) {
        Booking booking = bookingMapper.toEntity(bookingDTO);
        User user = userService.findByEmail(principal.getName()).orElseThrow(() -> new RuntimeException("unable to find user by username: " + principal.getName()));
        Long userId = user.getId();
        booking.getUser().setId(userId);
        String email = user.getEmail();
        booking.getItem().getUser().setId(userId);
        booking.setUserEmail(email);
        booking.getItem().setId(id);
        bookingRepository.save(booking);
    }

}

