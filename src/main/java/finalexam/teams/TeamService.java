package finalexam.teams;

import finalexam.players.Player;
import finalexam.players.PlayerNotFoundException;
import finalexam.players.PlayerRepository;
import finalexam.players.PositionType;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeamService {

    private TeamRepository repository;
    private ModelMapper modelMapper;
    private PlayerRepository playerRepository;

    public List<TeamDTO> listTeams() {
        return repository.findAll().stream()
                .map(t -> modelMapper.map(t, TeamDTO.class))
                .collect(Collectors.toList());
    }

    public TeamDTO createTeam(CreateTeamCommand command) {
        Team team = new Team(command.getName());
        repository.save(team);
        return modelMapper.map(team, TeamDTO.class);
    }

    @Transactional
    public TeamDTO updateWithExistingPlayer(long id, UpdateWithExistingPlayerCommand command) {
        Team team = repository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
        Player player = playerRepository.findById(command.getId()).orElseThrow(() -> new PlayerNotFoundException(command.getId()));
        if (player.getTeam() == null && getNumberOfPlayersInAnTeamWithPositionType(team, player.getPosition()) < 2) {
            team.addPlayer(player);
        }
        repository.save(team);
        return modelMapper.map(team, TeamDTO.class);
    }

    @Transactional
    public TeamDTO addPlayerToNotExistingTeam(long id, AddPlayerToNotExistingTeamCommand command) {
        Team team = repository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
        Player player = new Player(command.getName(), command.getBirthDate(), command.getPosition());
        playerRepository.save(player);
        team.addPlayer(player);
        repository.save(team);
        return modelMapper.map(team, TeamDTO.class);
    }

    private int getNumberOfPlayersInAnTeamWithPositionType(Team team, PositionType positionType) {
        int number = (int) team.getPlayers().stream()
                .filter(player -> player.getPosition() == positionType)
                .count();
        return number;
    }

}
