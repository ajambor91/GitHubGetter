package github.getter.Errors;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.resteasy.reactive.ClientWebApplicationException;

@Provider
public class HttpExceptionMapper implements ExceptionMapper<ClientWebApplicationException> {
    @Override
    public Response toResponse(ClientWebApplicationException exception) {

        return Response.status(exception.getResponse().getStatus())
                .entity(new HttpErrorResponseDTO(exception))
                .build();
    }
}
