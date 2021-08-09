package finalexam.players;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private PlayerRepository repository;
    private ModelMapper modelMapper;

    public PlayerDTO createPlayer(CreatePlayerCommand command) {
        Player player = new Player(command.getName(), command.getBirthDate(), command.getPosition());
        repository.save(player);
        return modelMapper.map(player, PlayerDTO.class);
    }

    public List<PlayerDTO> listPlayers() {
        return repository.findAll().stream()
                .map(t -> modelMapper.map(t, PlayerDTO.class))
                .collect(Collectors.toList());
    }

    public void deletePlayer(long id) {
        repository.deleteById(id);
    }

}
