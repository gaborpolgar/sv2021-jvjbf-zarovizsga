package org.training360.finalexam.teams;

import finalexam.players.PositionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPlayerToNotExistingTeamCommand {

    @NotBlank
    private String name;

    @NotNull
    private LocalDate birthDate;

    private PositionType position;

}
