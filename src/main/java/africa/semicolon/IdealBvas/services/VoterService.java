package africa.semicolon.IdealBvas.services;

import africa.semicolon.IdealBvas.dto.request.VoterRegistrationRequest;
import africa.semicolon.IdealBvas.dto.response.VoterRegistrationResponse;

public interface VoterService {
    VoterRegistrationResponse register(VoterRegistrationRequest voterRegistrationRequest);
}
