package lldcasestudies.casestudies.TickTackToe.strategies.WinningStrategy;

import lldcasestudies.casestudies.TickTackToe.models.Board;
import lldcasestudies.casestudies.TickTackToe.models.Game;
import lldcasestudies.casestudies.TickTackToe.models.Move;

public interface WinningStrategy {
    boolean isWinningMove(Board board, Move move);
}
