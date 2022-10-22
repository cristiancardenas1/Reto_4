package Repository.Crud;

import Model.Box;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoxRepository {
    @Autowired
    private BoxCrudRepository boxCrudRepository;

    public BoxRepository() {
    }

    public List<Box> getAll() {
        return (List)this.boxCrudRepository.findAll();
    }

    public Optional<Box> getBox(int id) {
        return this.boxCrudRepository.findById(id);
    }

    public Box save(Box box) {
        return (Box)this.boxCrudRepository.save(box);
    }

    public void delete(Box box) {
        this.boxCrudRepository.delete(box);
    }
}