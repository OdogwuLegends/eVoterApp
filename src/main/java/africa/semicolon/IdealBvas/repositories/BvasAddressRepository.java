package africa.semicolon.IdealBvas.repositories;

import africa.semicolon.IdealBvas.models.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BvasAddressRepository implements AddressRepository{
    List<Address> addresses = new ArrayList<>();
    private int id;

    @Override
    public Address findById(String id) {
        for(Address voterAddress : addresses){
            boolean sameAddress = Objects.equals(voterAddress.getId(),id);
            if(sameAddress) return voterAddress;
        }
        return null;
    }

    @Override
    public List<Address> findAll() {
        return addresses;
    }

    @Override
    public Address save(Address address) {
        address.setId(generateId());
        addresses.add(address);
        id++;
        return address;
    }
    private String generateId(){
        int addressId = id + 1;
        return Integer.toString(addressId);
    }

    @Override
    public void deleteById(String id) {
        Address foundAddress = findById(id);
        addresses.remove(foundAddress);
    }
    public int numberOfAddresses(){return addresses.size();}
}
