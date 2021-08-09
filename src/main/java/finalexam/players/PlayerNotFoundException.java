package finalexam.players;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class PlayerNotFoundException extends AbstractThrowableProblem {


    public PlayerNotFoundException(long id) {
        super(URI.create("teams/not-found"),
                "Not found",
                Status.NOT_FOUND,
                String.format("Team with id %d not found.", id));
    }
}