package africa.semicolon.IdealBvas.services;

import africa.semicolon.IdealBvas.dto.request.VoterRegistrationRequest;
import africa.semicolon.IdealBvas.dto.response.DeleteVoterResponse;
import africa.semicolon.IdealBvas.dto.response.VoterRegistrationResponse;
import africa.semicolon.IdealBvas.exceptions.VoterRegistrationException;
import africa.semicolon.IdealBvas.mapper.ModelMapper;
import africa.semicolon.IdealBvas.models.Address;
import africa.semicolon.IdealBvas.models.Gender;
import africa.semicolon.IdealBvas.models.UserInformation;
import africa.semicolon.IdealBvas.models.Voter;
import africa.semicolon.IdealBvas.repositories.BvasVoterRepository;
import africa.semicolon.IdealBvas.repositories.VoterRepository;

import java.util.List;
import java.util.UUID;

import static africa.semicolon.IdealBvas.Utils.AppUtils.*;

public class BvasVoterService implements VoterService{
    private final VoterRepository voterRepository = new BvasVoterRepository();

    @Override
    public VoterRegistrationResponse register(VoterRegistrationRequest voterRegistrationRequest) throws VoterRegistrationException {
        Voter voter = ModelMapper.map(voterRegistrationRequest);

        String VIN = generateVoterIdentificationNumber();
        voter.setVoterIdentificationNumber(VIN);
        Voter savedVoter = voterRepository.save(voter);

        if(savedVoter == null) throw new VoterRegistrationException("Voter registration failed");

        VoterRegistrationResponse voterRegistrationResponse = new VoterRegistrationResponse();
        voterRegistrationResponse.setMessage("Registration Successful. May your count.");
        voterRegistrationResponse.setVoterIdentificationNumber(savedVoter.getVoterIdentificationNumber());
        return voterRegistrationResponse;
    }

    @Override
    public Voter getUserById(String id) {
        return voterRepository.findById(id);
    }

    @Override
    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    @Override
    public DeleteVoterResponse deleteById(String id) {
        voterRepository.deleteById(id);
        return DeleteVoterResponse.builder().message("Voter deleted").build();
    }


    private static String generateVoterIdentificationNumber(){
        String uuid = generateUUID();
        String validUUID = stripInvalidCharactersFrom(uuid);
        return buildVoterIdentificationNumber(validUUID);
    }

    private static String buildVoterIdentificationNumber(String validUuid) {
        String result = "";
        for (int i = ZERO; i < validUuid.length(); i++) {
            if(i % FIVE == ZERO){
               result +=" ";
            }
            else result += validUuid.charAt(i);
        }
        int endIndex = result.length() - EIGHT;
        return result.substring(ZERO, endIndex).strip();
    }

    private static String stripInvalidCharactersFrom(String randomUuid) {
        String result = "";
        for (int i = ZERO; i < randomUuid.length(); i++) {
            if(randomUuid.charAt(i) != '-') result += randomUuid.charAt(i);
        }
        return result;
    }
    private static String generateUUID() {
        UUID randomUuid = UUID.randomUUID();
        return randomUuid.toString().toUpperCase();
    }
}
