package lldcasestudies.casestudies.TickTackToe.strategies.WinningStrategy;

import lldcasestudies.casestudies.TickTackToe.models.Board;
import lldcasestudies.casestudies.TickTackToe.models.CellState;
import lldcasestudies.casestudies.TickTackToe.models.Game;
import lldcasestudies.casestudies.TickTackToe.models.Move;

import java.util.HashMap;

public class DiagonalWinningStrategy implements WinningStrategy {
    HashMap<Character, Integer> leftDiagonal = new HashMap<>();// start from (0,0)
    HashMap<Character, Integer> rightDiagonal = new HashMap<>(); // start from (dimension-1,0)
    @Override
    public boolean isWinningMove(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        int dimension = board.getDimension();

        Character aChar = move.getPlayer().getSymbol().getAChar();
        if(row == col) {
          leftDiagonal.put(aChar, leftDiagonal.getOrDefault(aChar, 0) + 1);
        }
        if(row+col == dimension-1) {
            rightDiagonal.put(aChar, rightDiagonal.getOrDefault(aChar, 0) + 1);
        }
        if((row == col && leftDiagonal.get(aChar) == dimension) ||(row+col == dimension-1 && rightDiagonal.get(aChar) == dimension)) {
            return true;
        }

        return false;
    }
}
