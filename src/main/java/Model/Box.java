package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "box")
public class Box {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String name;
    private String location;
    private Integer capacity;

    private String description;

    @ManyToOne
    @JoinColumn(name= "categoryId")
    @JsonIgnoreProperties("boxes")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "box")
    @JsonIgnoreProperties({"box", "client"})
    private List<Message> message;

    @OneToMany( cascade = {CascadeType.PERSIST}, mappedBy = "box")
    @JsonIgnoreProperties({"box", "client"})
    public List<Reservation> reservation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
}