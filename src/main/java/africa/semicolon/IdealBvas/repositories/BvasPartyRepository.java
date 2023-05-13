package africa.semicolon.IdealBvas.repositories;

import africa.semicolon.IdealBvas.Utils.AppUtils;
import africa.semicolon.IdealBvas.models.Party;
import africa.semicolon.IdealBvas.models.UserInformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BvasPartyRepository implements PartyRepository{
    List<Party> politicalParties = new ArrayList<>();
    private final UserInformationRepository userInformationRepository = new BvasUserInformation();
    private int id;


    @Override
    public Party save(Party party) {
        party.setId(AppUtils.generateId());
        party.setName("PDP");
        boolean isPartyWithUserInformation = party.getUserInformation()!=null;
        if(isPartyWithUserInformation) saveUserInformation(party);
        politicalParties.add(party);
        return party;
    }

    private void saveUserInformation(Party party) {
        UserInformation savedUserInformation = userInformationRepository.save(party.getUserInformation());
        String partyId = party.getId();
        String userInformationId = savedUserInformation.getId();
        AppUtils.linkUserToInformation(partyId,userInformationId);
    }

    @Override
    public Party findById(String id) {
//        for(Party party : politicalParties){
//            if(party.getId().equals(id)) return party;
//        }
        Party foundParty = null;
        for(Party party : politicalParties){
            if(party.getId().equals(id)) foundParty = party;
        }
        if(foundParty!=null){
            String userInformationId = AppUtils.getUserInformationId(foundParty.getId());
            UserInformation userInformation = userInformationRepository.findById(userInformationId);
            foundParty.setUserInformation(userInformation);
        }
        return foundParty;
    }

    @Override
    public Party findByName(String name) {
        for(Party party : politicalParties){
            if (Objects.equals(party.getName(),name)) return party;
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        Party foundParty = findById(id);
        if(foundParty!=null) politicalParties.remove(foundParty);

//        var foundParty = findById(id);
//        if(foundParty!=null) politicalParties.remove(foundParty);
    }

    @Override
    public List<Party> findAll() {
        List<Party> foundPoliticalParties = new ArrayList<>();
        for(Party party : politicalParties){
            String userInformationId = AppUtils.getUserInformationId(party.getId());
            if(userInformationId!=null){
                UserInformation foundUserInformation = userInformationRepository.findById(userInformationId);
                party.setUserInformation(foundUserInformation);
            }
            foundPoliticalParties.add(party);
        }
        return foundPoliticalParties;
    }

//    @Override
//    public Party save(Party party) {
//        party.setId(generateId());
//        listOfParties.add(party);
//        id++;
//        return party;
//    }
//    @Override
//    public Party findById(String id) {
//        for(Party party : listOfParties){
//            boolean sameParty = Objects.equals(party.getId(), id);
//            if(sameParty) return party;
//        }
//        return null;
//    }

//    private String generateId(){
//        int partyId = id + 1;
//        return Integer.toString(partyId);
//    }

}
