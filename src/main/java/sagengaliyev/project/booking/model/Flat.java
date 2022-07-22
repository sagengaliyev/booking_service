package sagengaliyev.project.booking.model;

import javax.persistence.*;

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

    public Flat(long fid, String name, String location, String description, long price) {
        this.id = fid;
        this.name = name;
        this.location = location;
        this.description = description;
        this.price = price;
    }

    public Flat() {
    }

    public long getId() {
        return id;
    }

    public void setId(long fid) {
        this.id = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
