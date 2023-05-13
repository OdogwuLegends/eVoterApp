package africa.semicolon.IdealBvas.services;

import africa.semicolon.IdealBvas.dto.request.AdminRegistrationRequest;
import africa.semicolon.IdealBvas.dto.response.AdminRegistrationResponse;
import africa.semicolon.IdealBvas.dto.response.DeleteAdminResponse;
import africa.semicolon.IdealBvas.exceptions.AdminRegistrationException;
import africa.semicolon.IdealBvas.models.Admin;

import java.util.List;

public interface AdminService {
    AdminRegistrationResponse registerAdmin(AdminRegistrationRequest adminRegistrationRequest) throws AdminRegistrationException;
    Admin findById(String id);
    List<Admin> findAllAdmins();
    DeleteAdminResponse deleteById(String id);
}
