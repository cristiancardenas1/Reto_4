package Repository.Crud;

import Model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public ClientRepository() {
    }

    public List<Client> getAll() {

        return (List)this.clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id) {

        return this.clientCrudRepository.findById(id);
    }

    public Client save(Client client) {

        return (Client)this.clientCrudRepository.save(client);
    }

    public void delete(Client client) {

        this.clientCrudRepository.delete(client);
    }
}
