package Repository.Crud;

import Model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public CategoryRepository() {
    }

    public List<Category> getAll() {
        return (List)this.categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return this.categoryCrudRepository.findById(id);
    }

    public Category save(Category category) {
        return (Category)this.categoryCrudRepository.save(category);
    }

    public void delete(Category category) {
        this.categoryCrudRepository.delete(category);
    }
}