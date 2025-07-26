package lldcasestudies.casestudies.TickTackToe;

import lldcasestudies.casestudies.TickTackToe.controller.TTTController;
import lldcasestudies.casestudies.TickTackToe.factory.BotPlayingStratigyFactory;
import lldcasestudies.casestudies.TickTackToe.models.*;
import lldcasestudies.casestudies.TickTackToe.strategies.WinningStrategy.WinningStrategy;
import lldcasestudies.casestudies.TickTackToe.strategies.WinningStrategy.ColWinningStrategy;
import lldcasestudies.casestudies.TickTackToe.strategies.WinningStrategy.RowWinningStrategy;
import lldcasestudies.casestudies.TickTackToe.strategies.WinningStrategy.DiagonalWinningStrategy;

import java.util.List;
import java.util.Scanner;

public class TickTackToeMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimension of the board : ");
        int dimension = sc.nextInt();

//        List<Player> players = new ArrayList<>();
//        for(int i=0;i<dimension-1;i++) {
//            System.out.println("Enter the name of player "+(i+1)+" : ");
//            String name = sc.next();
//            System.out.println("Enter the symbol of player "+(i+1)+" : ");
//            String   s = sc.nextLine();
//            if(s.length()>1) throw new IllegalArgumentException("Symbol must be a single character");
//            Character aChar = s.charAt(0);
//            System.out.println("Enter the type of player "+(i+1)+" : ");
//            String s2 = sc.nextLine();
//            PlayerType playerType = PlayerType.valueOf(s2);
//            players.add(new Player(name,playerType,new Symbol(aChar)));
//        }
        BotPlayingStratigyFactory botPlayingStratigyFactory = new BotPlayingStratigyFactory();
        List<Player> players = List.of(
                new Player("Shivam", PlayerType.HUMAN, new Symbol('X')),
                new Bot("Scaler",PlayerType.BOT,new Symbol('O'),BotDifficltyLevel.EASY)
        );

        List<WinningStrategy> winningStrategies = List.of(
                new ColWinningStrategy(),
                new DiagonalWinningStrategy(),
                new RowWinningStrategy()
        );
        System.out.println("Start the game");
        Game game = new TTTController().startGame(dimension,players, winningStrategies);
        int count =0;
        while(game.getStateOfGame().equals(StateOfGame.IN_PROGRESS)) {

            TTTController.printBoard(game);
            if(count>0) {

                if (players.get(game.getIndexOfNextPLayer()).getPlayerType().equals(PlayerType.BOT)) {
                    TTTController.makeMove(game);
                    continue;
                }
                if (players.get(game.getIndexOfNextPLayer()).getPlayerType().equals(PlayerType.HUMAN)) {

                    System.out.println("Do you want to undo ? y/n");
                    String isUndo = sc.next();//make an undo operation

                    if(isUndo.equals("y")) TTTController.undo(game);

                }
            }

            TTTController.makeMove(game);

            count++;
        }
        game.printBoard(game.getBoard());
        System.out.println("Winner is " + TTTController.getWinner(game));
        System.out.println("Game Over");
    }
}
