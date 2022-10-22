package Controller;


import Model.Reservation;
import java.util.List;
import java.util.Optional;

import Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping({"/api/Reservation"})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping({"/all"})
    public List<Reservation> getAll() {
        return this.reservationService.getAll();
    }

    @GetMapping({"/{id}"})
    public Optional<Reservation> getReservation(@PathVariable("id") int id) {
        return this.reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {return reservationService.save(reservation);}
}

