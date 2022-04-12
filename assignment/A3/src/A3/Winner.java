package A3;

import java.util.ArrayList;

public class Winner {
    private String winner;

    public String getWinner(ArrayList<String> compare){
        System.out.println(compare);
        // 0,1,2: player
        // 3,4,5: dealer
        // 1: ♣   2: ♠   3: ♦  4: ♥

        return this.winner;
    }

    public void setWinner(String win){
        this.winner = win;
    }
}
