package africa.semicolon.IdealBvas.services;

import africa.semicolon.IdealBvas.dto.request.PartyRegistrationRequest;
import africa.semicolon.IdealBvas.dto.response.PartyRegistrationResponse;
import africa.semicolon.IdealBvas.exceptions.PartyRegistrationException;
import africa.semicolon.IdealBvas.models.Party;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static africa.semicolon.IdealBvas.Utils.AppUtils.ONE;
import static africa.semicolon.IdealBvas.Utils.AppUtils.ZERO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BvasPartyServiceTest {
    private final PartyService partyService = new BvasPartyService();
    private PartyRegistrationRequest partyRegistrationRequest;

    @BeforeEach
    void setUp(){
        partyRegistrationRequest = buildPartyRegistration();
    }


    @Test
    void testToRegisterParty(){
        try{
            PartyRegistrationResponse registrationResponse =
                    partyService.registerParty(partyRegistrationRequest);
            assertNotNull(registrationResponse);
        } catch (PartyRegistrationException ex){
            System.out.println(ex.getMessage());
        }
    }
    @Test
    void testToFindPartyById() throws PartyRegistrationException {
        var registrationResponse = partyService.registerParty(partyRegistrationRequest);
        List<Party> parties = partyService.findAllParties();
        Party lastRegisteredParty = parties.get(parties.size()-ONE);
        Party foundParty = partyService.findById(lastRegisteredParty.getId());
        assertNotNull(foundParty);
    }
    @Test
    void testToFindPartyByName() throws PartyRegistrationException {
        var registrationResponse = partyService.registerParty(partyRegistrationRequest);
        List<Party> parties = partyService.findAllParties();
        Party lastRegisteredParty = parties.get(parties.size()-1);
        Party foundParty = partyService.findByName(lastRegisteredParty.getName());
        assertNotNull(foundParty);
        assertEquals(partyRegistrationRequest.getName(),foundParty.getName());
    }


    @Test
    void testToFindAllParties() throws PartyRegistrationException {
        var registrationResponse = partyService.registerParty(partyRegistrationRequest);
        assertNotNull(registrationResponse);
        List<Party> parties = partyService.findAllParties();
        assertNotNull(parties);
        assertEquals(ONE,parties.size());
    }
    @Test
    void testToDeleteParty() throws PartyRegistrationException {
        partyService.registerParty(partyRegistrationRequest);
        List<Party> parties = partyService.findAllParties();
        Party lastRegisteredParty = parties.get(parties.size() - ONE);
        Party foundParty = partyService.findById(lastRegisteredParty.getId());
        partyService.deleteById(foundParty.getId());
        parties = partyService.findAllParties();
        assertEquals(ZERO,parties.size());

    }

    private static PartyRegistrationRequest buildPartyRegistration() {
        PartyRegistrationRequest partyRegistrationRequest1
                = new PartyRegistrationRequest();
        partyRegistrationRequest1.setName("PDP");
        partyRegistrationRequest1.setHouseNumber("99");
        partyRegistrationRequest1.setStreet("Wadata Plaza");
        partyRegistrationRequest1.setTown("Garki");
        partyRegistrationRequest1.setLga("Abuja Municipal");
        partyRegistrationRequest1.setState("FCT");
        partyRegistrationRequest1.setPassword("16yearsInPower");
        partyRegistrationRequest1.setUserName("myPDP");
        return partyRegistrationRequest1;
    }

}