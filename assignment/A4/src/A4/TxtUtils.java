package A4;

/**
 *
 * @author Qian Ruiling
 * @version 1.0
 */
public class TxtUtils {
    /**
     *
     * @return
     */
    public String waitFor(){
        return "Valid move, wait for your opponent";
    }

    /**
     *
     * @return
     */
    public String yourTurn(){
        return "Your opponent has moved, now please put down chess";
    }

    /**
     *
     * @return
     */
    public String win(){
        return "Congratulations. You Win!!!";
    }

    /**
     *
     * @return
     */
    public String lose(){
        return "Sorry, you have lost.";
    }

    /**
     *
     * @return
     */
    public String draw(){
        return "No winner, this game is draw.";
    }

    /**
     *
     * @return
     */
    public String invalid(){
        return "invalid";
    }

    /**
     *
     * @return
     */
    public String font(){
        return "Courier New";
    }

    public String message(){
        return """
                Some information about the game:
                Criteria for a valid move:
                - The move is not occupied buy any mark.
                - The move is made in the player's turn.
                - The move is made within the 3 X 3 board.
                The game should continue and switch among the opposite player until it reaches either one of the following conditions:
                - Player 1 wins.
                - Player 2 wins.
                - Draw.
                """;
    }
}
