package lldcasestudies.casestudies.TickTackToe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
    private  Player player;
    private Cell cell;
    public Move(Player player, Cell cell) {
        this.player = player;
        this.cell = cell;
    }
}
