package sagengaliyev.project.booking.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Booking")
@Data
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Item item;

    @Column(name = "to_user")
    private Long toUser;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "Price")
    private Long price;

    @Column(name = "People_number")
    private int humanNumber;

    @Column(name = "wishes")
    private String comments;

    @Column(name = "From_date")
    private LocalDate startDate;

    @Column(name = "Finish_date")
    private LocalDate finishDate;

    @Enumerated(EnumType.STRING)
    private Position position;
}
