package sagengaliyev.project.booking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import sagengaliyev.project.booking.model.Flat;
import sagengaliyev.project.booking.model.Position;
import sagengaliyev.project.booking.model.User;

import java.time.LocalDate;

@Data
public class BookingDTO {
    private Long id;
    private Long userId;
    private Long toUser;
    private Long itemId;
    private String userEmail;
    private Long price;
    private int humanNumber;
    private String comments;
    private Position position;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate finishDate;
}
