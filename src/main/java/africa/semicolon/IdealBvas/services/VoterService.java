package africa.semicolon.IdealBvas.services;

import africa.semicolon.IdealBvas.dto.request.VoterRegistrationRequest;
import africa.semicolon.IdealBvas.dto.response.DeleteVoterResponse;
import africa.semicolon.IdealBvas.dto.response.VoterRegistrationResponse;
import africa.semicolon.IdealBvas.exceptions.VoterRegistrationException;
import africa.semicolon.IdealBvas.models.Voter;

import java.util.List;

public interface VoterService {
    VoterRegistrationResponse register(VoterRegistrationRequest voterRegistrationRequest) throws VoterRegistrationException;
    Voter getUserById(String id);

    List<Voter> getAllVoters();
    DeleteVoterResponse deleteById(String id);


}
