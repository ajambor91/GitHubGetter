package github.getter.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("commit")
    private CommitDTO commitDTO;

    public String getName() {
        return name;
    }

    public CommitDTO getCommitDTO() {
        return commitDTO;
    }
}
