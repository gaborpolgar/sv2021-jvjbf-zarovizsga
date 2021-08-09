package finalexam.teams;

import finalexam.players.Player;
import finalexam.players.PlayerNotFoundException;
import finalexam.players.PlayerRepository;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private TeamRepository repository;
    private ModelMapper modelMapper;

    public TeamService(TeamRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Autowired
    private PlayerRepository playerRepository;

    public TeamDTO createTeam(CreateTeamCommand command) {
        Team team = new Team(command.getName());
        repository.save(team);
        return modelMapper.map(team, TeamDTO.class);
    }

    @Transactional
    public TeamDTO updateWithExistingPlayer(long id, UpdateWithExistingPlayerCommand command) {
        Team team = repository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
        Player player = playerRepository.findById(command.getId()).orElseThrow(() -> new PlayerNotFoundException(command.getId()));
        team.getPlayers().add(player);
        return modelMapper.map(team, TeamDTO.class);
    }

    @Transactional
    public TeamDTO addPlayerToNotExistingTeam(long id, AddPlayerToNotExistingTeamCommand command) {
        Team team = repository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
        Player player = new Player(command.getName(), command.getBirthDate(), command.getPosition());
        playerRepository.save(player);
        team.getPlayers().add(player);
        List<Player> players = new ArrayList<>(team.getPlayers());
        team.setPlayers(players);
        return modelMapper.map(team, TeamDTO.class);
    }

    public List<TeamDTO> listTeams() {
        return repository.findAll().stream()
                .map(t -> modelMapper.map(t, TeamDTO.class))
                .collect(Collectors.toList());
    }

//    public TeamDTO getTeamById(long id) {
//        Team team = repository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
//        return modelMapper.map(team, TeamDTO.class);
//    }

}
