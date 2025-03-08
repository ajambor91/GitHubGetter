package github.getter;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import github.getter.DTO.ResponseDTO;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/repos")
public class GithubResource {

    @Inject
    @RestClient
    GitHubService githubClient;

    @GET
    @Path("/{userName}")
    @Produces(MediaType.APPLICATION_JSON)

    public Uni<List<ResponseDTO>> getReposByUsername(@PathParam("userName") String userName) {
        return githubClient.getReposByUser(userName)
                .onItem().transformToMulti(repositoryDTOS -> Multi.createFrom().iterable(repositoryDTOS))
                .filter(repositoryDTO -> !repositoryDTO.isFork() && !repositoryDTO.isPrivate())
                .onItem()
                .transformToUniAndMerge(repositoryDTO ->
                        githubClient.getBranchesByRepository(repositoryDTO.getOwner().getLogin(), repositoryDTO.getName())
                                .onItem().transform(branchDTOs -> new ResponseDTO(
                                        repositoryDTO.getOwner().getLogin(),
                                        repositoryDTO.getName(),
                                        branchDTOs
                                ))
                )
                .collect().asList();
    }
}
