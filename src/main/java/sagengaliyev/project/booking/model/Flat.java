package sagengaliyev.project.booking.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Data
@Entity
@Table(name="Flat")
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Location")
    private String location;
    @Column(name = "Description")
    private String description;
    @Column(name = "Price")
    private long price;
    @Column(name = "Published_date")
    private LocalDate publishDate;
    @Column(name = "phone")
    private long phone;
    @ManyToOne
    private User owner;


}
