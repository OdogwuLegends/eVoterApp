package africa.semicolon.IdealBvas.repositories;

import africa.semicolon.IdealBvas.models.Address;
import africa.semicolon.IdealBvas.models.Gender;
import africa.semicolon.IdealBvas.models.UserInformation;
import africa.semicolon.IdealBvas.models.Voter;
import org.junit.jupiter.api.BeforeEach;

class BvasAddressRepositoryTest {
//    AddressRepository repository = new BvasAddressRepository();
//
//    @Test
//    void testToSaveAddress(){
//        Address firstVoterAddress = new Address();
//        Address secondVoterAddress = new Address();
//        repository.save(firstVoterAddress);
//        repository.save(secondVoterAddress);
//
//        assertEquals(2,repository.numberOfAddresses());
//    }
//    @Test
//    void testToFindAddressById(){
//        Address firstVoterAddress = new Address();
//        Address secondVoterAddress = new Address();
//        repository.save(firstVoterAddress);
//        repository.save(secondVoterAddress);
//
//        Address foundAddress = repository.findById("1");
//        assertSame(firstVoterAddress,foundAddress);
//        foundAddress = repository.findById("2");
//        assertSame(secondVoterAddress,foundAddress);
//    }
//    @Test
//    void testToDeleteAddressById(){
//        Address firstVoterAddress = new Address();
//        Address secondVoterAddress = new Address();
//        repository.save(firstVoterAddress);
//        repository.save(secondVoterAddress);
//
//        repository.deleteById("1");
//        assertEquals(1,repository.numberOfAddresses());
//
//        List<Address> addresses = repository.findAll();
//        assertFalse(addresses.contains(firstVoterAddress));
//    }
//    @Test
//    void testToFindAllAddresses(){
//        Address firstVoterAddress = new Address();
//        Address secondVoterAddress = new Address();
//        repository.save(firstVoterAddress);
//        repository.save(secondVoterAddress);
//
//        List<Address> addresses = repository.findAll();
//        assertEquals(2,addresses.size());
//        assertTrue(addresses.contains(secondVoterAddress));
//    }

    private final AddressRepository repository = new BvasAddressRepository();
    private Address savedAddress;

    @BeforeEach
    public void setUp(){
        Address foundAddress = buildAddressVoter();
        savedAddress = repository.save(foundAddress);
    }
    private Address buildAddressVoter(){
        Address address = new Address();

        address.setTown("Yaba");
        address.setState("Lagos");

        return address;
    }


}