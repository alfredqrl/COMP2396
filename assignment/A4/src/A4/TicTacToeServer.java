package A4;

import javax.annotation.processing.Generated;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Qian Ruiling
 * @version 1.0
 */
public class TicTacToeServer implements Runnable{
    private static TicTacToeServer server;
    private boolean running; // isRunning
    private Socket p1Soc;
    private Socket p2Soc;
    private GameResult gameResult;
    private PrintWriter p1Wrt;
    private PrintWriter p2Wrt;
    private BufferedReader p1Reader;
    private BufferedReader p2Reader;


    public static void main(String[] args) {
	    // write your code here
        server = new TicTacToeServer();
        server.gamePlay();
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run(){
        String nameP1 = Thread.currentThread().getName();
        boolean isP1 = nameP1.equals("Player 1");
        System.out.println("Thread Player 1 started");
        String res;
        while (this.running){
            try{
                res = read(isP1);
                process(isP1, res);
            } catch (IOException ex){
                write("end", "The game is end because one player left");
                setRunning(false);
            }
        }
    }

    /**
     *
     * @param val
     */
    public void setRunning(boolean val){
        this.running = val;
    }

    /**
     *
     * @param player1
     * @return
     * @throws IOException
     */
    public String read(boolean player1) throws IOException{
        String reVal;
        if (player1 == true){
            reVal = this.p1Reader.readLine();
        }else{
            reVal = this.p2Reader.readLine();
        }
        return reVal;
    }

    /**
     *
     * @param wVal
     * @param getData
     */
    public void write(String wVal, String getData){
        this.p1Wrt.println(wVal);
        this.p1Wrt.println(getData);
        this.p2Wrt.println(wVal);
        this.p2Wrt.println(getData);
    }

    /**
     *
     * @param isP1
     * @param reVal
     * @throws IOException
     */
    public void process(boolean isP1, String reVal) throws IOException{
        TxtUtils txtFile = new TxtUtils();
        if (reVal.equals("ok")){
            return;
        }
        String [] input = reVal.split(",");
        int col = Integer.parseInt(input[1]);
        int row = Integer.parseInt(input[0]);
        boolean v = gameResult.makeMove(isP1, row, col);
        if (v){
            write("board", gameResult.getBoardString());
            int check = gameResult.checkEndGame();
            if (check == 0){
                if (isP1){
                    write1("message", txtFile.waitFor());
                    write2("message", txtFile.yourTurn());
                }else{
                    write2("message", txtFile.waitFor());
                    write1("message", txtFile.yourTurn());
                }
            }else if (check == 1){
                write1("end", txtFile.win());
                write2("end", txtFile.lose());
                setRunning(false);
            }else if (check == 2){
                write1("end", txtFile.lose());
                write2("end", txtFile.win());
                setRunning(false);
            }else if (check == 3){
                write("end", txtFile.draw());
                setRunning(false);
            }else{
                System.out.println("Game not finish");
            }
        }else{
            write(txtFile.invalid(), "");
        }
    }

    /**
     *
     */
    public void gamePlay(){
        gameResult = new GameResult();
        try{
            ServerSocket socket = new ServerSocket(5000);
            server.p1Soc = socket.accept();

            System.out.println("Server is running...");
            server.p1Wrt = new PrintWriter(server.p1Soc.getOutputStream(), true);
            server.p1Reader = new BufferedReader(new InputStreamReader(server.p1Soc.getInputStream()));
            System.out.println("Player 1 connected");

            server.p2Soc = socket.accept();
            server.p2Wrt = new PrintWriter(server.p2Soc.getOutputStream(), true);
            server.p2Reader = new BufferedReader(new InputStreamReader(server.p2Soc.getInputStream()));
            System.out.println("Player 2 connected");

            setRunning(true);

            Thread p1 = new Thread(server);
            Thread p2 = new Thread(server);

            p1.setName("Player 1");
            p2.setName("Player 2");
            p1.start();
            p2.start();
            p1.join();
            p2.join();
            socket.close();

        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            System.out.println("No error for this function");
        }
    }

    private void write1(String w, String statement){
        p1Wrt.println(w);
        p1Wrt.println(statement);
    }

    private void write2(String w, String statement){
        p2Wrt.println(w);
        p2Wrt.println(statement);
    }
}
