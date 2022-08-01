package sagengaliyev.project.booking.model;

import lombok.*;


import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Name")
    private String name;
    @Column(name = "Email", unique = true)
    private String email;
    @Column(name = "Password")
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;



}
