package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(
        name = "reservation"
)
public class Reservation {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";
    @ManyToOne
    @JoinColumn(name = "boxId")
    @JsonIgnoreProperties({"reservation"})
    private Box box;
    @ManyToOne @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"reservation", "message"})
    private Client client;
    @OneToOne(cascade = {CascadeType.REMOVE}, mappedBy = "reservation")
    @JsonIgnoreProperties({"reservation"})
    private Score score;


    public Integer getIdReservation() {
        return this.idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return this.devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Box getBox() {
        return this.box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Score getScore() {
        return this.score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}