package Controller;

import Model.Box;
import Model.Category;
import Model.Message;
import Repository.Crud.MessageRepository;
import java.util.List;
import java.util.Optional;

import Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping({"/api/Message"})
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping({"/all"})
    public List<Message> getAll() {
        return this.messageService.getAll();
    }
    @GetMapping({"/{id}"})
    public Optional<Message> getMessage(@PathVariable("id") int id) {
        return this.messageService.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message) {return messageService.save(message);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message){
        return messageService.update(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return messageService.delete(id);
    }


}

