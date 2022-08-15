package sagengaliyev.project.booking.dto;

import lombok.Data;
import sagengaliyev.project.booking.model.User;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
public class ItemDTO {
    private Long id;
    private Long userId;
    private String name;
    private String location;
    private String description;
    private Long price;
    private Long phone;
    private LocalDate publishDate;
}
