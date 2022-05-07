

/**
 * This class provide txt output or input for Server and Client
 *
 * @author Qian Ruiling
 * @version 1.0
 */
public class TxtUtils {
    /**
     * This method provide string output in the client
     *
     * @return to another client if one client make a move
     */
    public String waitFor(){
        return "Valid move, wait for your opponent";
    }

    /**
     * This method provide string output in the client
     *
     * @return to the client that can make move
     */
    public String yourTurn(){
        return "Your opponent has moved, now please put down chess";
    }

    /**
     * This method provide string output in the client
     *
     * @return to the client if it wins the game
     */
    public String win(){
        return "Congratulations. You Win!!!";
    }

    /**
     * This method provide string output in the client
     *
     * @return to the client if it lost
     */
    public String lose(){
        return "Sorry, you have lost.";
    }

    /**
     * This method provide string output in the client
     *
     * @return to both clients if this game is drawn
     */
    public String draw(){
        return "No winner, this game is draw.";
    }

    /**
     * This method provide string output in the client
     *
     * @return when some small errors happened but not affect the game play
     */
    public String notFinished(){
        return "The game is not finished, an error might happened";
    }
    /**
     * This method provide string output in the client
     *
     * @return when the input or output is invalid or when the program reaches an invalid state
     */
    public String invalid(){
        return "invalid";
    }

    /**
     * This method provide string output in the client
     *
     * @return the rule of the game
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

    /**
     * This method provide string output in the client
     *
     * @return to another client if one client is disconnected
     */
    public String gameEnd(){
        return "The game is end because one player left";
    }
}
