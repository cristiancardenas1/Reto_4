package Controller;

import Model.Reservation;
import Model.Score;
import Repository.Crud.ScoreRepository;
import java.util.List;
import java.util.Optional;

import Services.ScoreService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping({"/api/Score"})
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping({"/all"})
    public List<Score> getAll() {
        return this.scoreService.getAll();
    }

    @GetMapping({"/{id}"})
    public Optional<Score> getScore(@PathVariable("id") int id) {
        return this.scoreService.getScore(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score) {return scoreService.save(score);}

}

