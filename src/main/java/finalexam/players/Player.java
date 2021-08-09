package finalexam.players;

import finalexam.teams.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "position_tpye")
    @Enumerated(value = EnumType.STRING)
    private PositionType position;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @ToString.Exclude
    private Team team;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, LocalDate birthDate, PositionType position) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
    }

    //    @Override
//    public String toString() {
//        return "Player{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                "birthDate=" + birthDate +
//                "position_tpye=" + position +
//                '}';
//    }
}
