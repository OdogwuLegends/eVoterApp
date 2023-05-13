package africa.semicolon.IdealBvas.services;

import africa.semicolon.IdealBvas.dto.request.VoterRegistrationRequest;
import africa.semicolon.IdealBvas.dto.response.VoterRegistrationResponse;
import africa.semicolon.IdealBvas.exceptions.VoterRegistrationException;
import africa.semicolon.IdealBvas.models.Voter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static africa.semicolon.IdealBvas.Utils.AppUtils.ONE;
import static africa.semicolon.IdealBvas.Utils.AppUtils.ZERO;
import static org.junit.jupiter.api.Assertions.*;

class BvasVoterServiceTest {
    private final VoterService voterService = new BvasVoterService();
    private VoterRegistrationRequest registrationRequest;
    @BeforeEach
    void setUp(){
       registrationRequest = buildVoterRegistrationRequest();
    }

    @Test
    void registerTest(){
        try{
            VoterRegistrationResponse registrationResponse =  voterService.register(registrationRequest);
            assertNotNull(registrationResponse);
            assertNotNull(registrationResponse.getVoterIdentificationNumber());
        }catch (VoterRegistrationException exception){
            System.out.println(exception);
        }

    }
    @Test
    void getVoterByIdTest() throws VoterRegistrationException {
        var registrationResponse = voterService.register(registrationRequest);
        List<Voter> voters = voterService.getAllVoters();
        Voter lastRegisteredVoter = voters.get(voters.size() - ONE);
        Voter foundVoter = voterService.getUserById(lastRegisteredVoter.getId());
        assertNotNull(foundVoter);
        assertEquals(registrationRequest.getName(),foundVoter.getName());
    }
    @Test
    void getAllVotersTest() throws VoterRegistrationException {
        var response = voterService.register(registrationRequest);
        assertNotNull(response);
        List<Voter> voters =voterService.getAllVoters();
        assertNotNull(voters);
        assertEquals(ONE,voters.size());
    }
    @Test
    void deleteVoterTest() throws VoterRegistrationException {
        voterService.register(registrationRequest);
        List<Voter> voters = voterService.getAllVoters();
        Voter lastRegisteredVoter = voters.get(voters.size() - ONE);
        Voter foundVoter = voterService.getUserById(lastRegisteredVoter.getId());
        voterService.deleteById(foundVoter.getId());
        voters = voterService.getAllVoters();
        assertEquals(ZERO,voters.size());
    }


    private static VoterRegistrationRequest buildVoterRegistrationRequest() {
        VoterRegistrationRequest registrationRequest = new VoterRegistrationRequest();
        registrationRequest.setAge(100);
        registrationRequest.setName("Sheriff");
        registrationRequest.setLga("TownHall");
        registrationRequest.setGender("OTHER");
        registrationRequest.setUserName("vawulence123@sheriff.com");
        registrationRequest.setPassword("idan123");
        registrationRequest.setState("IdanNation");
        registrationRequest.setTown("Sabo");
        registrationRequest.setStreet("Iyana Idan");
        registrationRequest.setHouseNumber("999");
        return registrationRequest;
    }
}