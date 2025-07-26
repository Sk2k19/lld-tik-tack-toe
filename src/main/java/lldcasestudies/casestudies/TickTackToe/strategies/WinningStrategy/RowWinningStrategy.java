package lldcasestudies.casestudies.TickTackToe.strategies.WinningStrategy;

import lldcasestudies.casestudies.TickTackToe.models.Board;
import lldcasestudies.casestudies.TickTackToe.models.Game;
import lldcasestudies.casestudies.TickTackToe.models.Move;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy {
    HashMap<Integer,HashMap<Character,Integer>> rowMaps = new HashMap<>();
    @Override
    public boolean isWinningMove(Board board, Move move) {


        int row = move.getCell().getRow();
        Character aChar = move.getPlayer().getSymbol().getAChar();
        if(!rowMaps.containsKey(row)) {
            rowMaps.put(row,new HashMap<>());
        }
        HashMap<Character,Integer> rowMap = rowMaps.get(row);
        if(!rowMap.containsKey(aChar)) {
            rowMap.put(aChar,0);
        }
        rowMap.put(aChar,rowMap.get(aChar)+1);
        if(rowMap.get(aChar).equals(board.getDimension())) {
            return true;
        }
        return false;
    }
}
