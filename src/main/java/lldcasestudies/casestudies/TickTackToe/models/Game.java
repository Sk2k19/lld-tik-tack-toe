package lldcasestudies.casestudies.TickTackToe.models;

import lldcasestudies.casestudies.TickTackToe.strategies.WinningStrategy.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter

public class Game {
    private Board board;
    private List<Player> players;
    private StateOfGame stateOfGame;
    private List<Move> moves;
    private Integer indexOfNextPLayer;
    private Player winner;
    private List<WinningStrategy> winningStrategies;
    private Game(Integer dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.stateOfGame = StateOfGame.IN_PROGRESS;
        this.indexOfNextPLayer = 0;
        this.winningStrategies = winningStrategies;
        this.moves = new ArrayList<>();
    }
    public static Builder getBuilder() {
        return new Builder();
    }
    public void printBoard(Board board) {
        board.printBoard();
    }
    public boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();
        int dimension = board.getDimension();
        if (row >= 0 && row < dimension && col >= 0 && col < dimension) {
            if (board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)) {
                return true;
            }
        }
        return false;
    }

    public void makeMove() {
        Player currentPlayer = players.get(indexOfNextPLayer);
        System.out.println("Turn of making move is " + currentPlayer.getName()+" ");
        Move tempMove = currentPlayer.makeMove(board);
        if(!validateMove(tempMove)) {
            throw new IllegalArgumentException("("+tempMove.getCell().getRow()+","+tempMove.getCell().getColumn()+") is not a valid move.The Stae of cell is "+ board.getBoard().get(tempMove.getCell().getRow()).get(tempMove.getCell().getColumn()).getCellState());
        }
        int row = tempMove.getCell().getRow();
        int col = tempMove.getCell().getColumn();
        Cell cell = board.getBoard().get(row).get(col);
        cell.setPlayer(currentPlayer);
        cell.setCellState(CellState.FILLED);

        Move finalMove = new Move(currentPlayer,cell);

        moves.add(finalMove);
        indexOfNextPLayer = (indexOfNextPLayer + 1) % players.size();


        if(checkWinner(finalMove)) {
            stateOfGame = StateOfGame.ENDED;
            winner = currentPlayer;
        }else if(moves.size() == board.getDimension() * board.getDimension()) {
            stateOfGame = StateOfGame.DRAW;
        }

        return;
    }

    public boolean checkWinner(Move move){
        for (WinningStrategy strategy : winningStrategies) {
            if (strategy.isWinningMove(this.board, move)) {
                return true;
            }
        }
        return false;
    }



    public static class Builder {
        private Integer dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        // constructor
        public Builder() {
            this.dimension = 0;
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
        }

        // validation methods ;
        public void checkUniqueChar(List<Player> players,Integer dimension) {
            Set<Character> set = new HashSet<>();
            for(Player p: players) {
                set.add(p.getSymbol().getAChar());
            }
            if(set.size()!= dimension-1) {
                throw new IllegalArgumentException("Symbole must be unique");
            }
        }
        public void checkBotCount(List<Player> players) {
            int count =0;
            for(Player p: players) {
                if (p.getPlayerType() == PlayerType.BOT) {
                    count++;
                    if (count > 1) {
                        throw new IllegalArgumentException("Only one bot is allowed");
                    }
                }
            }
        }

        public void validate() {
            checkUniqueChar(players,dimension);
            checkBotCount(players);
        }
        public Game build() {
            validate();
            return new Game(dimension, players, winningStrategies);
        }

        public Builder setDimension(Integer dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }


    }

}
