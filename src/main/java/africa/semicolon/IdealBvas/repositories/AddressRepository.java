package africa.semicolon.IdealBvas.repositories;

import africa.semicolon.IdealBvas.models.Address;
import java.util.List;

public interface AddressRepository {
    Address findById(String id);
    List<Address> findAll();
    Address save(Address address);
    void deleteById(String id);
    public int numberOfAddresses();
}
