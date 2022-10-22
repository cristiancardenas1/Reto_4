package Controller;

import Model.Admin;
import Services.AdminService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
@RestController
@RequestMapping({"/api/Admin"})
public class AdminController {
    @Autowired
    private AdminService adminService;

    public AdminController() {
    }

    @GetMapping({"/all"})
    public List<Admin> getAll() {
        return this.adminService.getAll();
    }

    @GetMapping({"/{id}"})
    public Optional<Admin> getAdmin(@PathVariable("id") int id) {
        return this.adminService.getAdmin(id);
    }

    @PostMapping({"/save"})
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin) {
        return this.adminService.save(admin);
    }
}
