package Services;

import Model.Admin;
import Repository.Crud.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public AdminService() {
    }

    public List<Admin> getAll() {
        return this.adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return this.adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin) {
        if(validarCampos(admin)) {
            if (admin.getIdAdmin() == null) {
                return this.adminRepository.save(admin);
            } else {
                Optional<Admin> adminOk = this.adminRepository.getAdmin(admin.getIdAdmin());
                return adminOk.isEmpty() ? this.adminRepository.save(admin) : admin;
            }
        }
        return  admin;
    }

    public Admin update(Admin admin) {
        if(validarCampos(admin)) {
            if (admin.getIdAdmin() != null) {
                Optional<Admin> adminOk = this.adminRepository.getAdmin(admin.getIdAdmin());
                if (adminOk.isEmpty()) {
                    if (admin.getPassword() != null) {
                        ((Admin) adminOk.get()).setPassword(admin.getPassword());
                    }

                    if (admin.getName() != null) {
                        ((Admin) adminOk.get()).setName(admin.getName());
                    }

                    return this.adminRepository.save((Admin) adminOk.get());
                }
            }
            return admin;
        }
        return admin;
    }

    public boolean deleteAdmin(int adminId) {
        Boolean resultado = (Boolean)this.getAdmin(adminId).map((adminPorEliminar) -> {
            this.adminRepository.delete(adminPorEliminar);
            return true;
        }).orElse(false);
        return resultado;
    }

    public boolean validarCampos(Admin admin){
        return(admin.getEmail().length() <= 45 && admin.getPassword().length() <= 45 && admin.getName().length() <= 250);
    }
}