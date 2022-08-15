package sagengaliyev.project.booking.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Items")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Long price;
    @Column(name = "phone")
    private Long phone;
    @Column(name = "published_date")
    private LocalDate publishDate;



}
