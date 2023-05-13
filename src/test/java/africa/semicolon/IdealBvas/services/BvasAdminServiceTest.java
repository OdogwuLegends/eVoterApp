package africa.semicolon.IdealBvas.services;


import africa.semicolon.IdealBvas.dto.request.AdminRegistrationRequest;
import africa.semicolon.IdealBvas.dto.response.AdminRegistrationResponse;
import africa.semicolon.IdealBvas.exceptions.AdminRegistrationException;
import africa.semicolon.IdealBvas.models.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static africa.semicolon.IdealBvas.Utils.AppUtils.ONE;
import static africa.semicolon.IdealBvas.Utils.AppUtils.ZERO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BvasAdminServiceTest {
    private final AdminService adminService = new BvasAdminService();
    private AdminRegistrationRequest adminRegistrationRequest = new AdminRegistrationRequest();


    @BeforeEach
    void setUp(){ adminRegistrationRequest = buildAdminRegistration(); }

    @Test
    void testToRegisterAdmin(){
        try{
            AdminRegistrationResponse adminRegistrationResponse
                    = adminService.registerAdmin(adminRegistrationRequest);
            assertNotNull(adminRegistrationResponse);
        } catch (AdminRegistrationException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void testToFindAdminById() throws AdminRegistrationException {
       adminService.registerAdmin(adminRegistrationRequest);
       List<Admin> adminList = adminService.findAllAdmins();
       Admin lastRegisteredAdmin = adminList.get(adminList.size() - ONE);
       Admin foundAdmin = adminService.findById(lastRegisteredAdmin.getId());
       assertNotNull(foundAdmin);
    }

    @Test
    void testToFindAllAdmins() throws AdminRegistrationException {
        adminService.registerAdmin(adminRegistrationRequest);
        assertNotNull(adminRegistrationRequest);
        List<Admin> adminList = adminService.findAllAdmins();
        assertNotNull(adminList);
        assertEquals(ONE,adminList.size());
    }
    @Test
    void testToDeleteAdmin() throws AdminRegistrationException {
        adminService.registerAdmin(adminRegistrationRequest);
        List<Admin> adminList = adminService.findAllAdmins();
        Admin lastRegisteredAdmin = adminList.get(adminList.size() - ONE);
        Admin foundAdmin = adminService.findById(lastRegisteredAdmin.getId());
        adminService.deleteById(foundAdmin.getId());
        adminList = adminService.findAllAdmins();
        assertEquals(ZERO,adminList.size());
    }

    private AdminRegistrationRequest buildAdminRegistration() {
        AdminRegistrationRequest adminRegistrationRequest
                = new AdminRegistrationRequest();
        adminRegistrationRequest.setFirstName("Ned");
        adminRegistrationRequest.setLastName("Stark");
        adminRegistrationRequest.setUserName("StarkOfJava");
        adminRegistrationRequest.setPassword("LP75");

        return adminRegistrationRequest;
    }



}