package Controller;

import Model.Category;
import Model.Client;
import Repository.Crud.ClientRepository;
import java.util.List;
import java.util.Optional;

import Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping({"/api/Client"})
public class ClientController {
    @Autowired
    private ClientService clientService;


    @GetMapping({"/all"})
    public List<Client> getAll() {
        return this.clientService.getAll();
    }
    @GetMapping({"/{id}"})
    public Optional<Client> getClient(@PathVariable("id") int id) {
        return this.clientService.getClient(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {return clientService.save(client);}
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return clientService.delete(id);
    }
}
