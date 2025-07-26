package lldcasestudies.casestudies.TickTackToe.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cell {
    private Integer row;
    private Integer column;
    private Player player;
    private CellState cellState;
    public Cell(Integer row, Integer column) {
        this.row = row;
        this.column = column;
        this.cellState = CellState.EMPTY;
    }
    public void printCell() {
        if (cellState == CellState.EMPTY) {
            System.out.print("|"+"--"+"|");
        } else if (cellState == CellState.FILLED) {
            System.out.print("|"+player.getSymbol().getAChar()+"|");
        }
    }
}
