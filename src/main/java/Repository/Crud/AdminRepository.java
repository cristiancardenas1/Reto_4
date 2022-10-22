package Repository.Crud;

import Model.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public AdminRepository() {
    }

    public List<Admin> getAll() {
        return (List)this.adminCrudRepository.findAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return this.adminCrudRepository.findById(id);
    }

    public Admin save(Admin admin) {
        return (Admin)this.adminCrudRepository.save(admin);
    }

    public void delete(Admin admin) {
        this.adminCrudRepository.delete(admin);
    }
}
