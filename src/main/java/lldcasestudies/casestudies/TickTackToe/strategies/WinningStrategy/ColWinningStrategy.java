package lldcasestudies.casestudies.TickTackToe.strategies.WinningStrategy;

import lldcasestudies.casestudies.TickTackToe.models.Board;
import lldcasestudies.casestudies.TickTackToe.models.Game;
import lldcasestudies.casestudies.TickTackToe.models.Move;

import java.util.HashMap;

public class ColWinningStrategy implements WinningStrategy {
    HashMap<Integer,HashMap<Character,Integer>> colMaps = new HashMap<>();
    @Override
    public boolean isWinningMove(Board board, Move move) {

        int col = move.getCell().getColumn();
        Character aChar = move.getPlayer().getSymbol().getAChar();

        if(!colMaps.containsKey(col)) {
            colMaps.put(col,new HashMap<>());
        }
        HashMap<Character,Integer> colMap = colMaps.get(col);
        if(!colMap.containsKey(aChar)) {
            colMap.put(aChar,0);
        }
        colMap.put(aChar,colMap.get(aChar) + 1);
        if(colMap.get(aChar).equals(board.getDimension())) return true;
        return false;
    }
}
