package africa.semicolon.IdealBvas.services;

import africa.semicolon.IdealBvas.dto.request.CreateElectionRequest;
import africa.semicolon.IdealBvas.dto.response.CreateElectionResponse;

public interface ElectionService {
    CreateElectionResponse create(CreateElectionRequest electionRequest);
}
