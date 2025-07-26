package lldcasestudies.casestudies.TickTackToe.strategies.botplayingStrategy;

import lldcasestudies.casestudies.TickTackToe.models.Board;
import lldcasestudies.casestudies.TickTackToe.models.Move;

public interface BotPlayingStrategy {
    public Move makeMove(Board board);
}
