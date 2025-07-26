package lldcasestudies.casestudies.TickTackToe.factory;

import lldcasestudies.casestudies.TickTackToe.models.BotDifficltyLevel;
import lldcasestudies.casestudies.TickTackToe.strategies.botplayingStrategy.*;
import lldcasestudies.casestudies.TickTackToe.strategies.botplayingStrategy.BotPlayingStrategy;

public  class BotPlayingStratigyFactory {
   public static BotPlayingStrategy getBotPlayingStrategy(BotDifficltyLevel botDifficltyLevel) {
       if(botDifficltyLevel.equals(BotDifficltyLevel.EASY)) {
           return new BotPlayingStrategyEasy();
       } else if(botDifficltyLevel.equals(BotDifficltyLevel.MEDIUM)) {
           return new BotPlayingStrategyMedium();
       } else {
           return new BotPlayingStrategyHard();
       }
   }
}
