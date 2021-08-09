package finalexam.teams;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDTO createTeam(@Valid @RequestBody CreateTeamCommand command){
        return teamService.createTeam(command);
    }

    @PostMapping("/api/teams/{id}/players")
    public TeamDTO updateWithExisitingPlayer(@PathVariable("id") long id, @RequestBody UpdateWithExistingPlayerCommand command) {
        return teamService.updateWithExistingPlayer(id, command);
    }

    @PutMapping("/api/teams/{id}/players")
    public TeamDTO AddPlayerToNotExistingTeam(@PathVariable("id") long id, @RequestBody AddPlayerToNotExistingTeamCommand command) {
        return teamService.addPlayerToNotExistingTeam(id, command);
    }

    @GetMapping
    public List<TeamDTO> listTeams() {
        return teamService.listTeams();
    }

    @GetMapping("/{id}")
    public TeamDTO getTeamById(@PathVariable("id") long id) {
        return teamService.getTeamById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeam(@PathVariable("id") long id) {
        teamService.deleteTeam(id);
    }


}
