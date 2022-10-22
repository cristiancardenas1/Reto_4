package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer idMessage;
    private String messageText;
    @ManyToOne
    @JoinColumn(name = "boxId")
    @JsonIgnoreProperties({"message", "reservation"})
    private Box box;
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"message", "reservation"})
    private Client client;


    public Integer getIdMessage() {
        return this.idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return this.messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
}
