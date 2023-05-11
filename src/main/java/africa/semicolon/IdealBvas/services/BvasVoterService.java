package africa.semicolon.IdealBvas.services;

import africa.semicolon.IdealBvas.dto.request.VoterRegistrationRequest;
import africa.semicolon.IdealBvas.dto.response.VoterRegistrationResponse;
import africa.semicolon.IdealBvas.models.Address;
import africa.semicolon.IdealBvas.models.Gender;
import africa.semicolon.IdealBvas.models.UserInformation;
import africa.semicolon.IdealBvas.models.Voter;

import java.math.BigInteger;
import java.util.UUID;

import static africa.semicolon.IdealBvas.Utils.AppUtils.*;

public class BvasVoterService implements VoterService{

    @Override
    public VoterRegistrationResponse register(VoterRegistrationRequest voterRegistrationRequest) {

        Address address = new Address();
        address.setTown(voterRegistrationRequest.getTown());
        address.setState(voterRegistrationRequest.getState());
        address.setStreet(voterRegistrationRequest.getStreet());
        address.setHouseNumber(voterRegistrationRequest.getHouseNumber());
        address.setLocalGovernmentArea(voterRegistrationRequest.getLga());
        Gender gender = Gender.valueOf(voterRegistrationRequest.getGender());

        UserInformation userInformation = new UserInformation();
        userInformation.setPassword(voterRegistrationRequest.getPassword());
        userInformation.setUserName(voterRegistrationRequest.getUserName());

        Voter voter  = new Voter();
        voter.setName(voterRegistrationRequest.getName());
        voter.setAge(voterRegistrationRequest.getAge());
        voter.setAddress(address);
        voter.setGender(gender);
        voter.setUserInformation(userInformation);

        VoterRegistrationResponse voterRegistrationResponse = new VoterRegistrationResponse();
        return null;
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

    public static void main(String[] args) {
        System.out.println(generateVoterIdentificationNumber());
    }
    private static String generateUUID() {
        UUID randomUuid = UUID.randomUUID();
        return randomUuid.toString().toUpperCase();
    }
}
