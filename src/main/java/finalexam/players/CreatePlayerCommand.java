package finalexam.players;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePlayerCommand {

    @NotBlank
    private String name;

    private LocalDate birthDate;

    private PositionType position;

    public CreatePlayerCommand(String name) {
        this.name = name;
    }
}
