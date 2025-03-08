package github.getter.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OwnerDTO {
    @JsonProperty("login")
    private String login;

    public String getLogin() {
        return login;
    }
}
