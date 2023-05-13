package africa.semicolon.IdealBvas.dto.request;

import africa.semicolon.IdealBvas.models.Party;
import lombok.Data;

import java.util.List;
@Data
 public class CreateElectionRequest {
    private String electionDate;
    private String electionCategory;
    private List<String> state;
    private List<String> localGovernment;
    private List<String> party;
}
