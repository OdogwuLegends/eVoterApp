package africa.semicolon.IdealBvas.services;

import africa.semicolon.IdealBvas.dto.request.PartyRegistrationRequest;
import africa.semicolon.IdealBvas.dto.response.DeletePartyResponse;
import africa.semicolon.IdealBvas.dto.response.PartyRegistrationResponse;
import africa.semicolon.IdealBvas.exceptions.PartyRegistrationException;
import africa.semicolon.IdealBvas.mapper.ModelMapper;
import africa.semicolon.IdealBvas.models.Party;
import africa.semicolon.IdealBvas.repositories.BvasPartyRepository;
import africa.semicolon.IdealBvas.repositories.PartyRepository;

import java.util.List;

public class BvasPartyService implements PartyService{
    private final PartyRepository partyRepository = new BvasPartyRepository();
    @Override
    public PartyRegistrationResponse registerParty(PartyRegistrationRequest partyRegistrationRequest) throws PartyRegistrationException {
        Party newParty = ModelMapper.map(partyRegistrationRequest);
        Party savedParty = partyRepository.save(newParty);

        if(savedParty == null) throw new PartyRegistrationException("Registration unsuccessful");

        PartyRegistrationResponse partyRegistrationResponse =
                new PartyRegistrationResponse();
        partyRegistrationResponse.setMessage("Registration successful.");
        return partyRegistrationResponse;
    }

    @Override
    public Party findById(String id) {
        return partyRepository.findById(id);
    }

    @Override
    public List<Party> findAllParties() {
        return partyRepository.findAll();
    }

    @Override
    public Party findByName(String name) {
        return partyRepository.findByName(name);
    }

    @Override
    public DeletePartyResponse deleteById(String id) {
        partyRepository.deleteById(id);
        return DeletePartyResponse.builder().message("Party deleted successfully").build();
    }
}
