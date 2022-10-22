package Repository.Crud;

import Model.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public ReservationRepository() {
    }

    public List<Reservation> getAll() {
        return (List)this.reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return this.reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return (Reservation)this.reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation) {
        this.reservationCrudRepository.delete(reservation);
    }
}