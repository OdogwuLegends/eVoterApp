package africa.semicolon.IdealBvas.mapper;

import africa.semicolon.IdealBvas.dto.request.AdminRegistrationRequest;
import africa.semicolon.IdealBvas.dto.request.CreateElectionRequest;
import africa.semicolon.IdealBvas.dto.request.PartyRegistrationRequest;
import africa.semicolon.IdealBvas.dto.request.VoterRegistrationRequest;
import africa.semicolon.IdealBvas.models.*;
import java.util.List;

public class ModelMapper {

    public static Voter map(VoterRegistrationRequest voterRegistrationRequest){
        Address address = buildVoterAddress(voterRegistrationRequest);
        UserInformation userInformation = buildVoterOnlineUserInformation(voterRegistrationRequest);
        Voter voter = buildVoter(voterRegistrationRequest, address, userInformation);
        return voter;
    }

    public static Election map(CreateElectionRequest createElectionRequest){
//        Election election = new Election();
//        Catergory electionCategory = Catergory.valueOf(createElectionRequest.getElectionCategory().toUpperCase());
//        election.setCatergory(electionCategory);
//        LocalDate electionDate = LocalDate.parse(createElectionRequest.getElectionDate());
//        election.setDate(electionDate);
//        List<Party> parties = getPoliticalParties(createElectionRequest.getParty());
//        election.setParties();
        return null;
    }
    public static Party map(PartyRegistrationRequest partyRegistrationRequest){
       UserInformation userInformation = buildPartyAppInformation(partyRegistrationRequest);
       Party newParty = buildParty(partyRegistrationRequest,userInformation);
       return newParty;
    }
    public static Admin map(AdminRegistrationRequest adminRegistrationRequest){
        UserInformation userInformation = buildAdminAppInformation(adminRegistrationRequest);
        Admin newAdmin = buildAdmin(adminRegistrationRequest,userInformation);
        return newAdmin;
    }

    private static Party buildParty(PartyRegistrationRequest partyRegistrationRequest, UserInformation userInformation){
        Party party = new Party();
        party.setName(partyRegistrationRequest.getName());
        party.setUserInformation(userInformation);
        return party;
    }
    private static Admin buildAdmin(AdminRegistrationRequest adminRegistrationRequest, UserInformation userInformation){
        Admin admin = new Admin();
        admin.setUserInformation(userInformation);
        return admin;
    }

    private static Voter buildVoter(VoterRegistrationRequest voterRegistrationRequest, Address address, UserInformation userInformation) {
//        Voter voter  = new Voter();
//        voter.setName(voterRegistrationRequest.getName());
//        voter.setAge(voterRegistrationRequest.getAge());
//        voter.setAddress(address);
//        voter.setGender(voterGender);
//        voter.setUserInformation(userInformation);
        //return voter;

        Gender voterGender = Gender.valueOf(voterRegistrationRequest.getGender().toUpperCase());
        return Voter.builder()
                .address(address)
                .gender(voterGender)
                .userInformation(userInformation)
                .name(voterRegistrationRequest.getName())
                .age(voterRegistrationRequest.getAge())
                .build();
    }

    private static UserInformation buildVoterOnlineUserInformation(VoterRegistrationRequest voterRegistrationRequest) {
        UserInformation userInformation = new UserInformation();
        userInformation.setPassword(voterRegistrationRequest.getPassword());
        userInformation.setUserName(voterRegistrationRequest.getUserName());
        return userInformation;
    }

    private static Address buildVoterAddress(VoterRegistrationRequest voterRegistrationRequest) {
        Address address = new Address();
        address.setTown(voterRegistrationRequest.getTown());
        address.setState(voterRegistrationRequest.getState());
        address.setStreet(voterRegistrationRequest.getStreet());
        address.setHouseNumber(voterRegistrationRequest.getHouseNumber());
        address.setLocalGovernmentArea(voterRegistrationRequest.getLga());
        return address;
    }
    private static UserInformation buildPartyAppInformation(PartyRegistrationRequest partyRegistrationRequest) {
        UserInformation userInformation = new UserInformation();
        userInformation.setPassword(partyRegistrationRequest.getPassword());
        userInformation.setUserName(partyRegistrationRequest.getUserName());
        return userInformation;
    }
    private static UserInformation buildAdminAppInformation(AdminRegistrationRequest adminRegistrationRequest){
        UserInformation userInformation = new UserInformation();
        userInformation.setUserName(adminRegistrationRequest.getUserName());
        userInformation.setPassword(adminRegistrationRequest.getPassword());
        return userInformation;
    }
    private static Address buildPartyAddress(PartyRegistrationRequest partyRegistrationRequest) {
        Address address = new Address();
        address.setTown(partyRegistrationRequest.getTown());
        address.setState(partyRegistrationRequest.getState());
        address.setStreet(partyRegistrationRequest.getStreet());
        address.setHouseNumber(partyRegistrationRequest.getHouseNumber());
        address.setLocalGovernmentArea(partyRegistrationRequest.getLga());
        return address;
    }

    private static List<Party> getPoliticalParties(List<String> party) {
        return null;
    }
}
