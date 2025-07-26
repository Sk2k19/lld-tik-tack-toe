package lldcasestudies.casestudies.TickTackToe.controller;

import lldcasestudies.casestudies.TickTackToe.models.Game;
import lldcasestudies.casestudies.TickTackToe.models.Player;
import lldcasestudies.casestudies.TickTackToe.models.StateOfGame;
import lldcasestudies.casestudies.TickTackToe.strategies.WinningStrategy.WinningStrategy;

import java.util.List;

public class TTTController {
    // start the game
    // get the option for undo
    // make a move
    // check if the game is over
    public Game startGame(Integer dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        return  new Game.Builder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();

    }
    public static void makeMove(Game game) {
        game.makeMove();
    }
    public static StateOfGame gameState(Game game) {
        return game.getStateOfGame();
    }

    public static String getWinner(Game game) {
        return game.getWinner().getName();
    }

    public static void printBoard(Game game) {
        game.printBoard(game.getBoard());
    }

    public static void undo(Game game) {

    }

}
