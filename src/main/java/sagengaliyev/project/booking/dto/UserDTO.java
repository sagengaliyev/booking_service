package sagengaliyev.project.booking.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String username;




}
