

import java.io.*;
import java.net.Socket;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates one Tic Tac Toe client to communicate with the server
 * 
 * @author Qian Ruiling
 * @version 3.0
 * */
public class TicTacToeClient implements Runnable {
	Socket sock;
	static JFrame frame;
	static BufferedReader reader;
	static PrintWriter writer;
	static JLabel[] board;
	static JLabel broadLabel;
	/**
	 * Open the game
	 *
	 * @throws RuntimeException when running contains some problems
	 */
	public void go() {  
		try {
			//setting up socket
			sock = new Socket("127.0.0.1", 5000);  
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());  
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream(),true);
			for (JLabel jLabel : board) {
				jLabel.setEnabled(true);
			}
			String type,arg;
			label:
			while(true) {
				type = reader.readLine();
				arg = reader.readLine();
				switch (type) {
					case "board":
						displayBoard(arg);
						break;
					case "message":
						broadLabel.setText(arg);
						break;
					case "end":
						JOptionPane.showMessageDialog(frame, arg);
						break label;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("No error here");
		}
	}

	/**
	 * The entry point of this class
	 *
	 * @param args unused
	 */
	public static void main(String[] args) {
		TxtUtils txtUtils = new TxtUtils();
		JPanel LayoutPanel = new JPanel();
		LayoutPanel.setLayout(new BorderLayout());
		LayoutPanel.setFont(new Font(txtUtils.font(), Font.BOLD, 24));
		
		broadLabel = new JLabel();
		broadLabel.setText("Enter your player name >>>");

		JPanel GameArea = new JPanel();
		GameArea.setLayout(new GridLayout(3, 3));

		board = new JLabel[9];
		
		Font font = new Font(txtUtils.font(), Font.BOLD, 100);
		Border border = BorderFactory.createLineBorder(Color.PINK, 3);
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JLabel label = new JLabel();
				label.setPreferredSize(new Dimension(100, 100));
				label.setFont(font);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBackground(Color.WHITE);
				label.setBorder(border);
				label.setEnabled(false);
				board[i + 3 * j] = label;
				final int i2 = i;
				final int j2 = j;
				label.addMouseListener(new MouseListener() {
					/**
					 * When the mouse clicked
					 *
					 * @param e the event to be processed
					 */
					@Override
					public void mouseClicked(MouseEvent e) {
						writer.println(i2 + "," + j2);
					}

					/**
					 * When the mouse is pressed
					 *
					 * @param e the event to be processed
					 */
					@Override
					public void mousePressed(MouseEvent e) {

					}

					/**
					 * When the mouse is released
					 *
					 * @param e the event to be processed
					 */
					@Override
					public void mouseReleased(MouseEvent e) {

					}

					/**
					 * When the mouse is entered
					 *
					 * @param e the event to be processed
					 */
					@Override
					public void mouseEntered(MouseEvent e) {

					}

					/**
					 * When the mouse is exited
					 *
					 * @param e the event to be processed
					 */
					@Override
					public void mouseExited(MouseEvent e) {

					}
				});
				GameArea.add(label);
			}
		}
		JPanel inputLayout = new JPanel(new GridLayout(1, 2));
		JTextField txtName = new JTextField(0);
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(e -> {
			txtName.setEnabled(false);
			btnSubmit.setEnabled(false);
			broadLabel.setText("WELCOME " + txtName.getText());
			TicTacToeClient client = new TicTacToeClient();
			Thread t = new Thread(client);
			t.start();
		});
		inputLayout.add(txtName);
		inputLayout.add(btnSubmit);
		LayoutPanel.add(broadLabel, BorderLayout.NORTH);
		LayoutPanel.add(GameArea, BorderLayout.CENTER);
		LayoutPanel.add(inputLayout, BorderLayout.SOUTH);
		JMenuItem menuExit = new JMenuItem("Exit");
		JMenuItem menuItemInstruction = new JMenuItem("Instruction");
		JMenu menuCont = new JMenu("Control");
		JMenu menuHelp = new JMenu("Help");
		menuCont.add(menuExit);
		menuHelp.add(menuItemInstruction);
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menuCont);
		menuBar.add(menuHelp);
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(LayoutPanel);
		frame.setJMenuBar(menuBar);
		frame.setTitle("Tic Tac Toe");
		frame.setSize(500, 600);

		menuExit.addActionListener(e -> {
			frame.setVisible(false);
			frame.dispose();
		});
		menuItemInstruction.addActionListener(e -> JOptionPane.showMessageDialog(frame, txtUtils.message()));
		frame.setVisible(true);
	}

	/**
	 * Display the 3 by 3 board
	 *
	 * @param str size of the board
	 */
	private void displayBoard(String str) {
		String[] boardString = str.split(",");
		for (int i = 0; i < 9; i++) {
			if (boardString[i].equals("1")) {
				board[i].setForeground(Color.RED);
				board[i].setText("X");

			}
			if (boardString[i].equals("0")) {
				board[i].setText("");
			}
			if (boardString[i].equals("-1")) {
				board[i].setForeground(Color.GREEN);
				board[i].setText("O");
			}
		}
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
	public void run() {
		this.go();
	}
}

