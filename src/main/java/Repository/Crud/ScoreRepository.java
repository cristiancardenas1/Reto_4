package Repository.Crud;

import Model.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public ScoreRepository() {
    }

    public List<Score> getAll() {
        return (List)this.scoreCrudRepository.findAll();
    }

    public Optional<Score> getScore(int id) {
        return this.scoreCrudRepository.findById(id);
    }

    public Score save(Score score) {
        return (Score)this.scoreCrudRepository.save(score);
    }

    public void delete(Score score) {
        this.scoreCrudRepository.delete(score);
    }
}