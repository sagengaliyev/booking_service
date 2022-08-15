package sagengaliyev.project.booking.mapper;

import org.springframework.stereotype.Component;
import sagengaliyev.project.booking.dto.BookingDTO;
import sagengaliyev.project.booking.model.Booking;

@Component
public class BookingMapper {

    private final FlatMapper flatMapper;
    private final UserMapper userMapper;
    private final ItemMapper itemMapper;

    public BookingMapper(FlatMapper flatMapper, UserMapper userMapper, ItemMapper itemMapper, ItemMapper itemMapper1) {
        this.flatMapper = flatMapper;
        this.userMapper = userMapper;
        this.itemMapper = itemMapper1;
    }

    public BookingDTO toDTO(Booking booking){
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setUserId(booking.getUser().getId());
        bookingDTO.setItemId(booking.getItem().getId());
        bookingDTO.setToUser(booking.getToUser());
        bookingDTO.setUserEmail(booking.getUserEmail());
        bookingDTO.setPrice(booking.getPrice());
        bookingDTO.setHumanNumber(booking.getHumanNumber());
        bookingDTO.setComments(booking.getComments());
        bookingDTO.setStartDate(booking.getStartDate());
        bookingDTO.setFinishDate(booking.getFinishDate());
        bookingDTO.setPosition(booking.getPosition());
        return bookingDTO;
    }

    public Booking toEntity(BookingDTO bookingDTO){
        Booking booking = new Booking();
        booking.setId(bookingDTO.getId());
        booking.setUser(userMapper.toEntityFromId(bookingDTO.getUserId()));
        booking.setToUser(bookingDTO.getToUser());
        booking.setItem(itemMapper.toEntityFromId(bookingDTO.getItemId()));
        booking.setUserEmail(bookingDTO.getUserEmail());
        booking.setPrice(bookingDTO.getPrice());
        booking.setHumanNumber(bookingDTO.getHumanNumber());
        booking.setComments(bookingDTO.getComments());
        booking.setStartDate(bookingDTO.getStartDate());
        booking.setFinishDate(bookingDTO.getFinishDate());
        booking.setPosition(bookingDTO.getPosition());
        return booking;
    }
}
