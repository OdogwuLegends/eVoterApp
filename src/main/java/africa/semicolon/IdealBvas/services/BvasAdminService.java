package africa.semicolon.IdealBvas.services;

import africa.semicolon.IdealBvas.dto.response.AdminRegistrationResponse;
import africa.semicolon.IdealBvas.dto.response.DeleteAdminResponse;
import africa.semicolon.IdealBvas.exceptions.AdminRegistrationException;
import africa.semicolon.IdealBvas.mapper.ModelMapper;
import africa.semicolon.IdealBvas.models.Admin;
import africa.semicolon.IdealBvas.repositories.AdminRepository;
import africa.semicolon.IdealBvas.repositories.BvasAdminRepository;

import java.util.List;

public class BvasAdminService implements AdminService{
    private final AdminRepository adminRepository = new BvasAdminRepository();
    @Override
    public AdminRegistrationResponse registerAdmin(africa.semicolon.IdealBvas.dto.request.AdminRegistrationRequest adminRegistrationRequest) throws AdminRegistrationException {
        Admin newAdmin = ModelMapper.map(adminRegistrationRequest);
        Admin saveAdmin = adminRepository.save(newAdmin);

        if(saveAdmin == null) throw new AdminRegistrationException("Registration unsuccessful");

        AdminRegistrationResponse adminRegistrationResponse =
                new AdminRegistrationResponse();
        adminRegistrationResponse.setMessage("Registration successful");
        return adminRegistrationResponse;
    }

    @Override
    public Admin findById(String id) {
        return adminRepository.findById(id);
    }

    @Override
    public List<Admin> findAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public DeleteAdminResponse deleteById(String id) {
        adminRepository.deleteById(id);
        return DeleteAdminResponse.builder().message("Admin deleted successfully").build();
    }
}
