package github.getter.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import java.util.List;
import java.util.stream.Collectors;

public class ResponseDTO {

    @JsonProperty("ownerName")
    private final String ownerName;

    @JsonProperty("repositoryName")
    private final String repositoryName;

    @JsonProperty("branches")
    private final List<BranchResponseDTO> branches;

    private record BranchResponseDTO(
            @JsonProperty("branchName") String branchName,
            @JsonProperty("lastCommitSHA") String lastCommitSHA
    ) {
        public BranchResponseDTO{
            branchName = Objects.requireNonNull(branchName);
            lastCommitSHA = Objects.requireNonNull(lastCommitSHA);
        }

        public BranchResponseDTO(BranchDTO branchDTO) {
            this(branchDTO.getName(), branchDTO.getCommitDTO().getSha());
        }

    }

    public ResponseDTO(String ownerLogin, String repositoryName, List<BranchDTO> branchResponse) {
        this.ownerName = Objects.requireNonNull(ownerLogin, "ownerLogin cannot be null");
        this.repositoryName = Objects.requireNonNull(repositoryName, "repositoryName cannot be null");
        this.branches = Objects.requireNonNull(branchResponse, "branchResponse cannot be null").stream()
                .map(BranchResponseDTO::new)
                .collect(Collectors.toList());
    }
}
