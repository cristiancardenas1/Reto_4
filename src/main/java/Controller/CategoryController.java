package Controller;

import Model.Category;
import java.util.List;
import java.util.Optional;

import Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping({"/api/Category"})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/all"})
    public List<Category> getAll() {
        return this.categoryService.getAll();
    }
    @GetMapping({"/{id}"})
    public Optional<Category> getCategory(@PathVariable("id") int id) {
        return this.categoryService.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {return categoryService.save(category);}

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return categoryService.delete(id);
    }

}

