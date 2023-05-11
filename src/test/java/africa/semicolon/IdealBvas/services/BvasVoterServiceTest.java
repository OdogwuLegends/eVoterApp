package africa.semicolon.IdealBvas.services;

import africa.semicolon.IdealBvas.dto.request.VoterRegistrationRequest;
import africa.semicolon.IdealBvas.dto.response.VoterRegistrationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BvasVoterServiceTest {
    private final VoterService voterService = new BvasVoterService();
    @BeforeEach
    void setUp(){

    }

    @Test
    void registerTest(){
        VoterRegistrationRequest registrationRequest = new VoterRegistrationRequest();
        registrationRequest.setAge(100);
        registrationRequest.setName("Sheriff");
        registrationRequest.setLga("TownHall");
        registrationRequest.setGender("OTHERS");
        registrationRequest.setUserName("vawulence123@sheriff.com");
        registrationRequest.setPassword("idan123");
        registrationRequest.setState("IdanNation");
        registrationRequest.setTown("Sabo");
        registrationRequest.setStreet("Iyana Idan");
        registrationRequest.setHouseNumber("999");

        VoterRegistrationResponse registrationResponse =  voterService.register(registrationRequest);

        assertNotNull(registrationResponse);
        assertNotNull(registrationResponse.getVoterIdentificationNumber());
    }
}