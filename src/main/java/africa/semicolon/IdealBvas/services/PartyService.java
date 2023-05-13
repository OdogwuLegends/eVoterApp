package africa.semicolon.IdealBvas.services;

import africa.semicolon.IdealBvas.dto.request.PartyRegistrationRequest;
import africa.semicolon.IdealBvas.dto.response.DeletePartyResponse;
import africa.semicolon.IdealBvas.dto.response.PartyRegistrationResponse;
import africa.semicolon.IdealBvas.exceptions.PartyRegistrationException;
import africa.semicolon.IdealBvas.models.Party;

import java.util.List;

public interface PartyService {
    PartyRegistrationResponse registerParty(PartyRegistrationRequest partyRegistrationRequest) throws PartyRegistrationException;
    Party findById(String id);
    List<Party> findAllParties();
    Party findByName(String name);
    DeletePartyResponse deleteById(String id);
}
