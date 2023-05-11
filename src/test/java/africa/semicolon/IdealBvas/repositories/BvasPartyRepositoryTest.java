package africa.semicolon.IdealBvas.repositories;

import africa.semicolon.IdealBvas.Utils.AppUtils;
import africa.semicolon.IdealBvas.models.Gender;
import africa.semicolon.IdealBvas.models.Party;
import africa.semicolon.IdealBvas.models.UserInformation;
import africa.semicolon.IdealBvas.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasPartyRepositoryTest {
    //BvasPartyRepository repository = new BvasPartyRepository();

//    @Test
//    void testToSavePartyToRepo(){
//        Party newParty = new Party();
//        repository.save(newParty);
//
//        int actual = repository.numberOfParties();
//        assertEquals(1,actual);
//    }
//    @Test
//    void testToFindPartyById(){
//        Party firstParty = new Party();
//        Party secondParty = new Party();
//        Party thirdParty = new Party();
//
//        repository.save(firstParty);
//        repository.save(secondParty);
//        repository.save(thirdParty);
//
//        Party foundParty = repository.findById("2");
//        assertSame(secondParty,foundParty);
//        foundParty = repository.findById("3");
//        assertSame(thirdParty,foundParty);
//        foundParty = repository.findById("1");
//        assertSame(firstParty,foundParty);
//    }
//
//    @Test
//    void testToDeletePartyById(){
//        Party firstParty = new Party();
//        Party secondParty = new Party();
//        Party thirdParty = new Party();
//
//        repository.save(firstParty);
//        repository.save(secondParty);
//        repository.save(thirdParty);
//
//        repository.deleteById("1");
//        assertEquals(2,repository.numberOfParties());
//        repository.deleteById("3");
//        assertEquals(1,repository.numberOfParties());
//        repository.deleteById("2");
//        assertEquals(0,repository.numberOfParties());
//    }
//
//    @Test
//    void testToFindAllParties(){
//        Party firstParty = new Party();
//        Party secondParty = new Party();
//        Party thirdParty = new Party();
//
//        repository.save(firstParty);
//        repository.save(secondParty);
//        repository.save(thirdParty);
//
//        List<Party> parties = repository.findAll();
//        assertEquals(3,parties.size());
//        assertTrue(parties.contains(secondParty));
//    }

    private final PartyRepository repository = new BvasPartyRepository();
    private final UserInformationRepository infoRepository = new BvasUserInformation();
    private Party savedParty;
    private UserInformation userInformation;

    @BeforeEach
    void setUp(){
        Party party = buildParty();
        savedParty = repository.save(party);
        //UserInformation userInfo = buildInfo();
        //userInformation = infoRepository.save(userInfo);
    }

    @Test
    void testToSaveParty(){
        assertNotNull(savedParty);

        List<Party> countOfParties = repository.findAll();
        assertEquals(1,countOfParties.size());

    }

    @Test
    void testToFindById(){
        Party foundParty = repository.findById(savedParty.getId());
        assertNotNull(foundParty);
    }

    @Test
    void testToDeletePartyById(){
        List<Party> countOfParties = repository.findAll();
        assertEquals(1,countOfParties.size());

        repository.deleteById(savedParty.getId());
        //assertEquals(0,countOfParties.size());
    }
    @Test
    void testToFindAllParties(){
        Party secondParty = new Party();
        Party thirdParty = new Party();
        repository.save(secondParty);
        repository.save(thirdParty);

        List<Party> countOfParties = repository.findAll();
        assertTrue(countOfParties.contains(thirdParty));
        assertEquals(3,countOfParties.size());
    }

    private Party buildParty() {
        UserInformation information = new UserInformation();
        Party party = new Party();


        information.setPassword("1234");
        information.setUserName("OdogwuLegends");

        //System.out.println(party.getUserInformation());

        return party;
    }
    private UserInformation buildInfo(){
        UserInformation information = new UserInformation();

        information.setPassword("1234");
        information.setUserName("OdogwuLegends");
        information.setId(savedParty.getId());
        return information;
    }

}