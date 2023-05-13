package africa.semicolon.IdealBvas.dto.request;

import africa.semicolon.IdealBvas.models.Address;
import africa.semicolon.IdealBvas.models.UserInformation;
import lombok.Data;

@Data
public class PartyRegistrationRequest {
    private String name;
    private String userName;
    private String password;
    private String houseNumber;
    private String street;
    private String town;
    private String lga;
    private String state;
}
