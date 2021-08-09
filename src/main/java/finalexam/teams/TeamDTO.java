package finalexam.teams;

import com.fasterxml.jackson.annotation.JsonBackReference;
import finalexam.players.PlayerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {

    private Long id;
    private String name;

    @JsonBackReference
    @ToString.Exclude
    private List<PlayerDTO> players;

}
