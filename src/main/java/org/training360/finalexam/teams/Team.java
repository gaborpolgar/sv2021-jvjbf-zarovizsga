package org.training360.finalexam.teams;

import finalexam.players.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name")
    private String name;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "team")
    private List<Player> players;

    public Team(String name) {
        this.name = name;
    }
}
