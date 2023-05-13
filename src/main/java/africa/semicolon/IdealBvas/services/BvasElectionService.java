package africa.semicolon.IdealBvas.services;

import africa.semicolon.IdealBvas.dto.request.CreateElectionRequest;
import africa.semicolon.IdealBvas.dto.response.CreateElectionResponse;
import africa.semicolon.IdealBvas.repositories.BvasElectionRepository;
import africa.semicolon.IdealBvas.repositories.ElectionRepository;

public class BvasElectionService implements ElectionService{

    private final ElectionRepository electionRepository = new BvasElectionRepository();
    @Override
    public CreateElectionResponse create(CreateElectionRequest createElectionRequest) {
        return null;
    }
}
