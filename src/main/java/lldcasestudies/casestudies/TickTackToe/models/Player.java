package lldcasestudies.casestudies.TickTackToe.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.Scanner;

@Getter
@Setter
public class Player {
    private String name;
    private PlayerType playerType;
    private Symbol symbol;
    public static Scanner sc = new Scanner(System.in);
    public Player(String name, PlayerType playerType, Symbol symbol) {
        this.name = name;
        this.playerType = playerType;
        this.symbol = symbol;
    }
     public Move makeMove(Board board) {
        System.out.println("Enter the row  : ");
        int row = sc.nextInt();
        System.out.println("Enter the column : ");
        int col = sc.nextInt();

        return new Move(this,new Cell(row,col));
    }
}
