package africa.semicolon.IdealBvas.repositories;

import africa.semicolon.IdealBvas.models.Party;
import java.util.List;

public interface PartyRepository {
    Party findById(String id);
    Party findByName(String name);
    List<Party> findAll();
    Party save(Party party);
    void deleteById(String id);
}
