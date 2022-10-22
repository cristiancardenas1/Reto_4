package Controller;

import Model.Box;
import Model.Category;
import Repository.Crud.BoxRepository;
import java.util.List;
import java.util.Optional;

import Services.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping({"/api/Box"})
public class BoxController {
    @Autowired
    private BoxService boxService;

    @GetMapping({"/all"})
    public List<Box> getAll() {
        return this.boxService.getAll();
    }
    @GetMapping({"/{id}"})
    public Optional<Box> getBox(@PathVariable("id") int id) {
        return this.boxService.getBox(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Box save(@RequestBody Box box) {return boxService.save(box);}
}
