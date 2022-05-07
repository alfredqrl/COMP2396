package A4;

/**
 *
 * @author Qian Ruiling
 * @version 1.0
 */
public class GameResult {
    private int count;
    private boolean isPlayer1; // isPlayer1Turn
    private int[][] board;

    /**
     *
     */
    public GameResult(){
        this.isPlayer1 = true;
        this.count = 0;
        this.board = new int[3][3];
    }

    /**
     *
     * @param isP1
     * @param row
     * @param col
     * @return
     */
    public synchronized boolean makeMove(boolean isP1, int row, int col){
        if (!isPlayerTurn(isP1)){
            return false;
        }
        if (board[col][row] != 0){
            return false;
        }
        if (isP1){
            board[col][row] = 1;
        }else{
            board[col][row] = -1;
        }
        this.count = this.count + 1;
        this.isPlayer1 = !this.isPlayer1;
        return true;
    }

    private boolean isPlayerTurn(boolean p){
        return (p && this.isPlayer1) || (!p && !this.isPlayer1);
    }

    /**
     *
     * @return
     */
    public String getBoardString(){
        StringBuilder boardString = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardString.append(Integer.toString(board[i][j])).append(",");
            }
        }
        return boardString.substring(0, boardString.length()-1);
    }

    /**
     *
     * @return
     */
    public int checkEndGame(){
        int col, row;
        int dia = board[0][0] + board[1][1] + board[2][2];
        int dia2 = board[2][0] + board[1][1] + board[0][2];
        for (int i = 0; i < 3; i++) {
            row = board[i][0] + board[i][1] + board[i][2];
            if (row == 3){
                return 1;
            }
            if (row == -3){
                return 2;
            }
        }
        for (int j = 0; j < 3; j++) {
            col = board[0][j] + board[1][j] + board[2][j];
            if (col == 3){
                return 1;
            }
            if (col == -3){
                return 2;
            }
        }
        if (dia == 3){
            return 1;
        }
        if (dia == -3) {
            return 2;
        }
        if (dia2 == 3){
            return 1;
        }
        if (dia2 == -3){
            return 2;
        }
        if (this.count == 9){
            return 3;
        }
        return 0;
    }
}
