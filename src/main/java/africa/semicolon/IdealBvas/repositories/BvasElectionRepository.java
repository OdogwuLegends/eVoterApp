package africa.semicolon.IdealBvas.repositories;

import africa.semicolon.IdealBvas.Utils.AppUtils;
import africa.semicolon.IdealBvas.models.Election;

import java.util.ArrayList;
import java.util.List;

public class BvasElectionRepository implements ElectionRepository{
    private final List<Election> elections = new ArrayList<>();
    @Override
    public Election findBy(String id) {
        return elections.stream().filter(election -> election.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public List<Election> findAll() {
        return elections;
    }

    @Override
    public Election save(Election election) {
        election.setId(AppUtils.generateId());
        elections.add(election);
        return election;
    }

    @Override
    public void deleteById(String id) {
        Election foundElection = findBy(id);
        if (foundElection!=null) elections.remove(foundElection);
    }
}
