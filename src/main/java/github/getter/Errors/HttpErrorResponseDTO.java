package github.getter.Errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jboss.resteasy.reactive.ClientWebApplicationException;

import java.util.Objects;

public class HttpErrorResponseDTO {
    @JsonProperty("status")
    private final int status;

    @JsonProperty("message")
    private final String errorMessage;
    private record ApiErrorDTO(@JsonProperty("message") String message, @JsonProperty("status") int status) {

        public ApiErrorDTO {
            status = Objects.requireNonNull(status);
            message = Objects.requireNonNull(message);
        }

    }

    public HttpErrorResponseDTO(ClientWebApplicationException webApplicationException) {
        ApiErrorDTO apiErrorDTO = webApplicationException.getResponse().readEntity(ApiErrorDTO.class);
        this.status = apiErrorDTO.status;
        this.errorMessage = apiErrorDTO.message;
    }
}
