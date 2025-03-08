package github.getter;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import github.getter.DTO.BranchDTO;
import github.getter.DTO.RepositoryDTO;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;
@RegisterRestClient
@ClientHeaderParam(name = "User-Agent", value = "MyGitHubApp/1.0")
@ClientHeaderParam(name = "Accept", value = "application/json")
public interface GitHubService {

    @GET
    @Path("/users/{userName}/repos")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<RepositoryDTO>> getReposByUser(@PathParam("userName") String userName);

    @GET
    @Path("/repos/{userName}/{repository}/branches")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<BranchDTO>> getBranchesByRepository(@PathParam("userName") String username, @PathParam("repository") String branches);

}
