package lldcasestudies.casestudies.TickTackToe.models;

import lldcasestudies.casestudies.TickTackToe.factory.BotPlayingStratigyFactory;
import lldcasestudies.casestudies.TickTackToe.strategies.botplayingStrategy.BotPlayingStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player{

        BotDifficltyLevel botDifficltyLevel;
        BotPlayingStrategy botPlayingStrategy; // interface which helps bot to play according difficlty level.
        public Bot(String name, PlayerType playerType, Symbol symbol, BotDifficltyLevel botDifficltyLevel) {
            super(name, playerType, symbol);
            this.botDifficltyLevel = botDifficltyLevel;
            this.botPlayingStrategy = BotPlayingStratigyFactory.getBotPlayingStrategy(botDifficltyLevel);
        }
//    @Override
//    public Move makeMove(Board board) {
//        return botPlayingStrategy.makeMove(board);
//    }
    @Override
    public Move makeMove(Board board) {
        return botPlayingStrategy.makeMove(board);
    }

}