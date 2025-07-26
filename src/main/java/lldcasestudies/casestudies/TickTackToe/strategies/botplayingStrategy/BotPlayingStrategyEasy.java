package lldcasestudies.casestudies.TickTackToe.strategies.botplayingStrategy;

import lldcasestudies.casestudies.TickTackToe.models.*;

import java.util.List;

public class BotPlayingStrategyEasy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row :board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
//                    cell.setCellState(CellState.FILLED);

                    return new Move(null, cell);
                }
            }
        }
        return null;
    }
}
