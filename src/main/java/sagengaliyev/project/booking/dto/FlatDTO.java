package sagengaliyev.project.booking.dto;

import lombok.Data;
import sagengaliyev.project.booking.model.Flat;

@Data
public class FlatDTO {
    private long id;
    private String name;
    private String location;
    private String description;
    private long price;

}
