package africa.semicolon.IdealBvas.repositories;

import africa.semicolon.IdealBvas.models.Election;

import java.util.List;

public interface ElectionRepository {
    Election findBy(String id);
    List<Election> findAll();
    Election save(Election election);
    void deleteById(String id);
}
