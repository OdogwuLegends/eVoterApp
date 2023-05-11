package africa.semicolon.IdealBvas.repositories;

import africa.semicolon.IdealBvas.models.Admin;
import africa.semicolon.IdealBvas.models.Party;
import africa.semicolon.IdealBvas.models.UserInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasAdminRepositoryTest {
//    AdminRepository repository = new BvasAdminRepository();
//
//    @Test
//    void testToSaveAdmin(){
//        Admin firstAdmin = new Admin();
//        Admin secondAdmin = new Admin();
//        repository.save(firstAdmin);
//        repository.save(secondAdmin);
//
//        assertEquals(2,repository.numberOfAdmins());
//    }
//    @Test
//    void testToFindAdminById(){
//        Admin firstAdmin = new Admin();
//        Admin secondAdmin = new Admin();
//        repository.save(firstAdmin);
//        repository.save(secondAdmin);
//
//        Admin foundAdmin = repository.findById("2");
//        assertSame(secondAdmin,foundAdmin);
//        foundAdmin = repository.findById("1");
//        assertSame(firstAdmin,foundAdmin);
//    }
//    @Test
//    void testToDeleteAdminById(){
//        Admin firstAdmin = new Admin();
//        Admin secondAdmin = new Admin();
//        repository.save(firstAdmin);
//        repository.save(secondAdmin);
//
//        repository.deleteById("1");
//        assertEquals(1,repository.numberOfAdmins());
//        repository.deleteById("2");
//        assertEquals(0,repository.numberOfAdmins());
//    }
//    @Test
//    void testToFindAllAdmins(){
//        Admin firstAdmin = new Admin();
//        Admin secondAdmin = new Admin();
//        repository.save(firstAdmin);
//        repository.save(secondAdmin);
//
//        List<Admin> admins = repository.findAll();
//        assertEquals(2,admins.size());
//    }

    private final AdminRepository repository = new BvasAdminRepository();
    private final UserInformationRepository infoRepository = new BvasUserInformation();
    private Admin savedAmin;
    private UserInformation userInformation;

    @BeforeEach
    void setUp(){
//        Admin admin = buildAminTest();
//        savedAmin = repository.save(admin);
//        UserInformation userInfo = buildInfo();
//        userInformation = infoRepository.save(userInfo);

        Admin admin = new Admin();
        UserInformation userInformation = new UserInformation();
        userInformation.setUserName("favour_white");
        userInformation.setPassword("dominik");
        admin.setUserInformation(userInformation);
        savedAmin = repository.save(admin);

    }

    @Test
    void testToSaveAdmin(){
        List<Admin> countOfAdmins = repository.findAll();
        assertEquals(1,countOfAdmins.size());
        assertNotNull(countOfAdmins.contains(savedAmin));
        assertFalse(countOfAdmins.isEmpty());
    }

    @Test
    void testToFindAdminById(){
        Admin secondAdmin = new Admin();
        repository.save(secondAdmin);
        assertNotNull(savedAmin.getUserInformation());
        Admin sameAdmin = repository.findById(savedAmin.getId());
        assertSame(savedAmin,sameAdmin);
        sameAdmin = repository.findById(secondAdmin.getId());
        assertSame(secondAdmin,sameAdmin);

    }
    @Test
    void testToDeleteAdminById(){
        repository.deleteById(savedAmin.getId());

        List<Admin> countOfAdmins = repository.findAll();
        assertEquals(0,countOfAdmins.size());
        assertFalse(countOfAdmins.contains(savedAmin));
        assertTrue(countOfAdmins.isEmpty());
    }

    @Test
    void testToFindAllAdmins(){
        Admin secondAdmin = new Admin();
        Admin thirdAdmin = new Admin();
        repository.save(secondAdmin);
        repository.save(thirdAdmin);

        List<Admin> countOfAdmins = repository.findAll();
        assertEquals(3,countOfAdmins.size());
        assertTrue(countOfAdmins.contains(secondAdmin));
    }

    private Admin buildAminTest() {
        Admin admin = new Admin();
        UserInformation information = new UserInformation();


        information.setPassword("1234");
        information.setUserName("OdogwuLegends");
        admin.setUserInformation(information);
        return admin;
    }
    private UserInformation buildInfo(){
        UserInformation information = new UserInformation();

        information.setPassword("1234");
        information.setUserName("OdogwuLegends");
        information.setId(savedAmin.getId());
        return information;
    }
}