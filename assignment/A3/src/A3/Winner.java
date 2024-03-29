package A3;

import java.util.ArrayList;

/**
 * This class demonstrates who win in one round
 *
 * @author Qian Ruiling
 * @version 3.0
 */
public class Winner {
    private String winner;

    /**
     * This method will calculate and return the winner to the Game class
     *
     * @param compare The cards received by player and dealer
     * @return Who win in this round
     */
    public String getWinner(ArrayList<String> compare){
        //System.out.println(compare);
        // 0,1,2: player
        // 3,4,5: dealer
        // 1: ♣   2: ♠   3: ♦  4: ♥
        //System.out.println(d1);
        if (!checkSpecialCards(compare).equals("again")){
            setWinner(checkSpecialCards(compare));
        }else{
            if (checkFaceVal(compare).equals("player")){
                setWinner(checkFaceVal(compare));
            }else{
                setWinner("dealer");
            }
        }
        return this.winner;
    }

    /**
     * This method will set the winner for returning
     *
     * @param win winner in this round
     */
    public void setWinner(String win){
        this.winner = win;
    }

    /**
     * This method will perform rule 1 to determine the winner
     *
     * @param compare The cards received by player and dealer
     * @return Who win determined by rule 1
     */
    public String checkSpecialCards(ArrayList<String> compare){
        int counterPlayer = 0;
        int counterDealer = 0;
        String d1 = compare.get(3).substring(6);
        String d2 = compare.get(4).substring(6);
        String d3 = compare.get(5).substring(6);
        String p1 = compare.get(0).substring(6);
        String p2 = compare.get(1).substring(6);
        String p3 = compare.get(2).substring(6);
        //System.out.println(d1);
        if (Integer.parseInt(d1) > 10){
            counterDealer++;
        }
        if (Integer.parseInt(d2) > 10){
            counterDealer++;
        }
        if (Integer.parseInt(d3) > 10){
            counterDealer++;
        }
        if (Integer.parseInt(p1) > 10){
            counterPlayer++;
        }
        if (Integer.parseInt(p2) > 10){
            counterPlayer++;
        }
        if (Integer.parseInt(p3) > 10){
            counterPlayer++;
        }

        if (counterDealer > counterPlayer){
            return "dealer";
        }else if (counterDealer < counterPlayer){
            return "player";
        }else{
            return "again";
        }
    }

    /**
     * This method will perform rule 2 to determine the winner
     *
     * @param compare The cards received by player and dealer
     * @return Who win determined by rule 2
     */
    public String checkFaceVal(ArrayList<String> compare){
        System.out.println();
        int facePlayer = 0;
        int faceDealer = 0;
        String d1 = compare.get(3).substring(6);
        String d2 = compare.get(4).substring(6);
        String d3 = compare.get(5).substring(6);
        String p1 = compare.get(0).substring(6);
        String p2 = compare.get(1).substring(6);
        String p3 = compare.get(2).substring(6);

        if (Integer.parseInt(d1) <= 10){
            faceDealer = faceDealer + Integer.parseInt(d1);
        }
        if (Integer.parseInt(d2) <= 10){
            faceDealer = faceDealer + Integer.parseInt(d2);
        }
        if (Integer.parseInt(d3) <= 10){
            faceDealer = faceDealer + Integer.parseInt(d3);
        }
        if (Integer.parseInt(p1) <= 10){
            facePlayer = facePlayer + Integer.parseInt(p1);
        }
        if (Integer.parseInt(p2) <= 10){
            facePlayer = facePlayer + Integer.parseInt(p2);
        }
        if (Integer.parseInt(p3) <= 10){
            facePlayer = facePlayer + Integer.parseInt(p3);
        }
        //System.out.println(faceDealer);
        //System.out.println(facePlayer);
        faceDealer = faceDealer % 10;
        facePlayer = facePlayer % 10;

        //System.out.println("Final dealer: " + faceDealer);
        //System.out.println("Final player: " + facePlayer);

        if (facePlayer > faceDealer){
            //System.out.println("player");
            return "player";
        }else{
            //System.out.println("dealer");
            return "dealer";
        }
    }
}
