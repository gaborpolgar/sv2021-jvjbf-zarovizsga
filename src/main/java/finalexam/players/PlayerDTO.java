package finalexam.players;

import finalexam.teams.TeamDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private Long id;

    private String name;

    private LocalDate birthDate;

    private PositionType position;

    private TeamDTO team;

}
