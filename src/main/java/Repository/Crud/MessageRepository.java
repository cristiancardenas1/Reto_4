package Repository.Crud;

import Model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public MessageRepository() {
    }

    public List<Message> getAll() {

        return (List)this.messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id) {
        return this.messageCrudRepository.findById(id);
    }

    public Message save(Message message) {
        return (Message)this.messageCrudRepository.save(message);
    }

    public void delete(Message message) {
        this.messageCrudRepository.delete(message);
    }
}

