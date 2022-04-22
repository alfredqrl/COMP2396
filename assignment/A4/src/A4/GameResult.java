package A4;

/**
 *
 * @author Qian Ruiling
 * @version 1.0
 */
public class GameResult {

    /**
     *
     */
    public GameResult(){

    }

    /**
     *
     * @param isP1
     * @param row
     * @param col
     * @return
     */
    public synchronized boolean makeMove(boolean isP1, int row, int col){

        return false;
    }

    /**
     *
     * @return
     */
    public String getBoardString(){

        return "";
    }

    /**
     *
     * @return
     */
    public int checkEndGame(){

        return -1;
    }
}
