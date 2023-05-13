package africa.semicolon.IdealBvas.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Election {
    private String id;
    private LocalDate date;
    private Catergory catergory;
    private List<Party> parties;
}
