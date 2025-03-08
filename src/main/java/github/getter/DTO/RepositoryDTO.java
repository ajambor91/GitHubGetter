package github.getter.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private OwnerDTO owner;
    @JsonProperty("fork")
    private boolean fork;
    @JsonProperty("private")
    private boolean isPrivate;

    public String getName() {
        return name;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public boolean isFork() {
        return fork;
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
