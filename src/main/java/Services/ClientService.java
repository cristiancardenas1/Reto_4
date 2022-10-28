package Services;

import Model.Client;
import Repository.Crud.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
   private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client client){
        if(validarCampos(client)) {
            if (client.getIdClient() == null) {
                return clientRepository.save(client);
            } else {
                Optional<Client> clientEncontrado = getClient(client.getIdClient());
                if (clientEncontrado.isEmpty()) {
                    return clientRepository.save(client);
                } else {
                    return client;
                }
            }
        }
        return client;
    }

    public Client update(Client client){
        if(validarCampos(client)) {
            if (client.getIdClient() != null) {
                Optional<Client> clientEncontrado = clientRepository.getClient(client.getIdClient());
                if (!clientEncontrado.isEmpty()) {
                    if (client.getName() != null) {
                        clientEncontrado.get().setName(client.getName());
                    }
                    if (client.getAge() != null) {
                        clientEncontrado.get().setAge(client.getAge());
                    }
                    if (client.getPassword() != null) {
                        clientEncontrado.get().setPassword(client.getPassword());
                    }
                    return clientRepository.save(clientEncontrado.get());
                }
            }
            return client;
        }
        return client;
    }

    public boolean delete(int id){
        boolean respuesta = getClient(id).map(elemento ->{
            clientRepository.delete(elemento);
            return true;
        }).orElse(false);

        return respuesta;
    }
    public boolean validarCampos(Client client){
        return(client.getEmail().length() <= 45 && client.getPassword().length() <= 45 && client.getName().length() <= 250
                && client.getAge() > 0 && client.getAge()<= 115);
    }

}

