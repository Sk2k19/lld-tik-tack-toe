package lldcasestudies.casestudies.TickTackToe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symbol {
    private Character aChar;

    public Symbol(Character aChar) {

        this.aChar = aChar;
    }
}
