package sagengaliyev.project.booking.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UserDTO {

    private Long id;
    private String email;
    private String password;

}
