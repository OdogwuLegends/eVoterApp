package africa.semicolon.IdealBvas.repositories;

import africa.semicolon.IdealBvas.models.Address;
import africa.semicolon.IdealBvas.models.Gender;
import africa.semicolon.IdealBvas.models.UserInformation;
import africa.semicolon.IdealBvas.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasVoterRepositoryTest {
    //private final VoterRepository repository = new BvasVoterRepository();

//    @Test
//    void testToSaveVoterToRepo(){
//        Voter newVoter = new Voter();
//
//        Address address = new Address();
//        address.setHouseNumber("12");
//        address.setTown("Yaba");
//
//        newVoter.setName("Legend");
//        newVoter.setAge(25);
//        newVoter.setGender(Gender.MALE);
//        newVoter.setVoterIdentificationNumber("007");
//        newVoter.setAddress(address);
//
//
//        repository.save(newVoter);
//        int actual = repository.numberOfVoters();
//        assertEquals(1,actual);
//
//    }
//
//    @Test
//    void testToFindVoterById(){
//        Voter firstVoter = new Voter();
//        repository.save(firstVoter);
//        Voter secondVoter = new Voter();
//        repository.save(secondVoter);
//
//        Voter actual = repository.findById("1");
//        assertSame(firstVoter,actual);
//        actual = repository.findById("2");
//        assertSame(secondVoter,actual);
//    }
//
//    @Test
//    void testToDeleteVoterById(){
//        Voter firstVoter = new Voter();
//        repository.save(firstVoter);
//        Voter secondVoter = new Voter();
//        repository.save(secondVoter);
//        Voter thirdVoter = new Voter();
//        repository.save(thirdVoter);
//
//        repository.deleteById("2");
//        int actual = repository.numberOfVoters();
//        assertEquals(2,actual);
//    }
//
//    @Test
//    void testToFindAllVoters(){
//        Voter firstVoter = new Voter();
//        repository.save(firstVoter);
//        Voter secondVoter = new Voter();
//        repository.save(secondVoter);
//
//        List<Voter> voters = repository.findAll();
//        assertEquals(2,voters.size());
//        assertTrue(voters.contains(firstVoter));
//        assertTrue(voters.contains(secondVoter));
//    }

    private final VoterRepository repository = new BvasVoterRepository();
    private final UserInformationRepository infoRepository = new BvasUserInformation();
    private Voter savedVoter;
    private UserInformation userInformation;

    @BeforeEach
    public void setUp(){
        Voter voter = buildTestVoter();
        savedVoter = repository.save(voter);
        UserInformation userInfo = buildInfo();
        userInformation = infoRepository.save(userInfo);
    }

    @Test
    void testSaveVoter(){
       assertNotNull(savedVoter);
       assertNotNull(savedVoter.getId());
    }
    @Test
    void testFindAllVoters(){
        Voter secondVoter = new Voter();
        Voter thirdVoter = new Voter();
        repository.save(secondVoter);
        repository.save(thirdVoter);
        List<Voter> allVoters = repository.findAll();
        assertEquals(3,allVoters.size());
        assertNotNull(allVoters.get(0));
        assertNotNull(allVoters.get(1));
        assertNotNull(allVoters.get(2));
    }

    @Test
    void testFindById(){
        Voter foundVoter = repository.findById(savedVoter.getId());
        assertNotNull(foundVoter);
    }
    @Test
    void testDeleteVoterById(){
        Voter secondVoter = new Voter();
        Voter thirdVoter = new Voter();
        repository.save(secondVoter);
        repository.save(thirdVoter);

        List<Voter> allVoters = repository.findAll();
        assertEquals(3,allVoters.size());

        repository.deleteById(secondVoter.getId());
        assertEquals(2,allVoters.size());

    }

    private Voter buildTestVoter(){
     Voter voter = new Voter();
     UserInformation information = new UserInformation();

     voter.setName("John Doe");
     voter.setAge(20);
     voter.setGender(Gender.MALE);
     information.setPassword("1234");
     information.setUserName("OdogwuLegends");
     voter.setUserInformation(information);
     return voter;
    }
    private UserInformation buildInfo(){
        UserInformation information = new UserInformation();

        information.setPassword("1234");
        information.setUserName("OdogwuLegends");
        information.setId(savedVoter.getId());
        return information;
    }


}