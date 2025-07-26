package lldcasestudies.casestudies.TickTackToe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Board {
    private Integer dimension;
    List<List<Cell>> board;

    public Board(Integer dimension) {
        this.dimension = dimension;
        board = new ArrayList<>();
        for(int i = 0; i < dimension; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < dimension; j++) {
                board.get(i).add(new Cell(i,j));
            }

        }
    }
    public void printBoard() {
        for (List<Cell> row : board) {
            for (Cell cell : row) {
                cell.printCell();
            }
            System.out.println();
        }
    }
}
