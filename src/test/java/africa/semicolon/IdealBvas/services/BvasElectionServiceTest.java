package africa.semicolon.IdealBvas.services;

import africa.semicolon.IdealBvas.dto.request.CreateElectionRequest;
import africa.semicolon.IdealBvas.dto.response.CreateElectionResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasElectionServiceTest {
    private final  ElectionService electionService = new BvasElectionService();

    @BeforeEach
    void setUp(){

    }

    @Test
    void createElectionTest() {
//        CreateElectionRequest createElectionRequest = new CreateElectionRequest();
//        createElectionRequest.setElectionCategory("GUBERNATORIAL");
//        createElectionRequest.setElectionDate("2023-02-25");
//        List<String> parties = getParties();
//        createElectionRequest.setParty(parties);
//        List<String> states = getStates();
//        createElectionRequest.setState(states);
//
//
//
//
//        CreateElectionResponse createElectionResponse = electionService.create(createElectionRequest);
//        assertNotNull(createElectionResponse);
        CreateElectionRequest createElectionRequest = new CreateElectionRequest();
        createElectionRequest.setElectionCategory("GUBERNATORIAL");
        createElectionRequest.setElectionDate("2023-02-25");
        List<String> parties = getParties();
        createElectionRequest.setParty(parties);
        List<String> states = getStates();
        createElectionRequest.setState(states);
        CreateElectionResponse createElectionResponse =
                electionService.create(createElectionRequest);
        assertNotNull(createElectionResponse);
        //assertNull(createElectionResponse);
    }

    private static List<String> getParties() {
        List<String> parties = new ArrayList<>();
        parties.add("PDP");
        parties.add("APC");
        parties.add("LP");
        parties.add("NNPP");
        return parties;
    }

    private static List<String> getStates(){
        List<String> states = new ArrayList<>();

        states.add("Lagos");
        states.add("Kano");
        states.add("Kaduna");
        return states;
    }
}