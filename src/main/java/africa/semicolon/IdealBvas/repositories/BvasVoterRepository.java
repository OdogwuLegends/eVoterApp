package africa.semicolon.IdealBvas.repositories;

import africa.semicolon.IdealBvas.Utils.AppUtils;
import africa.semicolon.IdealBvas.models.Voter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BvasVoterRepository implements VoterRepository{
    List<Voter> votersList = new ArrayList<>();
    private int id;

    @Override
    public Voter save(Voter voter){
        String id = AppUtils.generateId();
        voter.setId(id);
        votersList.add(voter);
        return voter;
    }

    @Override
    public Voter findById(String id) {
        for(Voter voter : votersList){
            if(voter.getId().equals(id)) return voter;
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        Voter foundVoter = findById(id);
        if(foundVoter!=null) votersList.remove(foundVoter);
    }

    @Override
    public List<Voter> findAll() {
        return votersList;
    }

//    @Override
//    public List<Voter> findAll() {
//        return votersList;
//    }

//    @Override
//    public Voter save(Voter voter) {
//        voter.setId(generateId());
//        votersList.add(voter);
//        id++;
//        return voter;
//    }


//    @Override
//    public Voter findById(String id) {
//        for (Voter voter : votersList) {
//            boolean IdMatches = Objects.equals(voter.getId(), id);
//            if (IdMatches) return voter;
//        }
//        return null;
//    }


//    @Override
//    public void deleteById(String id) {
//        Voter voter = findById(id);
//        votersList.remove(voter);
//    }

//    private String generateId(){
//        int voterId = id + 1;
//        return Integer.toString(voterId);
//    }

//    @Override
//    public int numberOfVoters() {
//        return votersList.size();
//    }
}
