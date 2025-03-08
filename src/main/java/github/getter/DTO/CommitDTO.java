package github.getter.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitDTO {
    @JsonProperty("sha")
    private String sha;

    public String getSha() {
        return this.sha;
    }
}
