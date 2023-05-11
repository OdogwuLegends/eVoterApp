package africa.semicolon.IdealBvas.repositories;

import africa.semicolon.IdealBvas.models.Admin;
import java.util.List;

public interface AdminRepository {
    Admin findById(String id);
    List<Admin> findAll();
    Admin save(Admin admin);
    void deleteById(String id);
    int numberOfAdmins();
}
