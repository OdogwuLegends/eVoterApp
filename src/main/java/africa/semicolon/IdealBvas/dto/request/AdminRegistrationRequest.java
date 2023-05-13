package africa.semicolon.IdealBvas.dto.request;

import lombok.Data;

@Data
public class AdminRegistrationRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
}
