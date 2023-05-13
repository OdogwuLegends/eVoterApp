package africa.semicolon.IdealBvas.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Party {
    private String id;
    private UserInformation userInformation;
    private String name;
}
