package A4;
import java.io.*;
import java.net.Socket;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

/**
 * This class creates an instance of TicTacToeClient and communicates with a TicTacToeServer.
 * 
 * @author Peter
 * 
 * */
public class TicTacToeClient implements Runnable {
	Socket sock;
	static JFrame frame;
	static PrintWriter writer;
	static BufferedReader reader;
	static JLabel broadcastLabel;
	static JLabel[] board;
	
	/**
	 * Connects and starts conversation with a TicTacToeServer.
	 * 
	 * */
	public void go() {  
		try {
			//setting up socket
			sock = new Socket("127.0.0.1", 5000);  
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());  
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream(),true);
			
			//enabling the labels
			for (JLabel jLabel : board) {
				jLabel.setEnabled(true);
			}
			
			//start conversation with server
			String type,arg;
			label:
			while(true) {
				type = reader.readLine();
				arg = reader.readLine();
//				System.out.println("client receive: " + type +" "+arg);
				
				//process received message
				switch (type) {
					case "board":
						displayBoard(arg);
						break;
					case "message":
						broadcastLabel.setText(arg);
						break;
					case "end":
						JOptionPane.showMessageDialog(frame, arg);
						break label;
				}
				
			}
		} catch (Exception ex) { 
			ex.printStackTrace(); 
		}
	}
	
	/**
	 * Running go() on a thread.
	 * 
	 * */
	public void run() {
		this.go();
	}
	
	private void displayBoard(String str) {
		
		String[] boardStr = str.split(",");
		for (int i = 0; i < 9; i++) {
			if (boardStr[i].equals("1")) {
				board[i].setForeground(Color.RED);
				board[i].setText("X");
				
			}
			if (boardStr[i].equals("0")) {
				board[i].setText("");
			}
			if (boardStr[i].equals("-1")) {
				board[i].setForeground(Color.GREEN);
				board[i].setText("O");
			}
		}
		//return;
	}

	public static void main(String[] args) {
		TxtUtils txtUtils = new TxtUtils();
		JPanel LayoutPanel = new JPanel();
		LayoutPanel.setLayout(new BorderLayout());
		LayoutPanel.setFont(new Font(txtUtils.font(), Font.BOLD, 24));
		
		broadcastLabel = new JLabel();
		broadcastLabel.setText("Enter your player name >>>");

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
				final int _i = i;
				final int _j = j;
				label.addMouseListener(new MouseListener() {
					
					public void mouseClicked(MouseEvent e) {
						writer.println(_i + "," + _j);
					}

					
					public void mousePressed(MouseEvent e) {

					}

					
					public void mouseReleased(MouseEvent e) {

					}

					
					public void mouseEntered(MouseEvent e) {

					}

					
					public void mouseExited(MouseEvent e) {

					}
				});
				GameArea.add(label);
			}
		}

		JPanel inputLayout = new JPanel(new GridLayout(1, 2));
		JTextField txtInput_name = new JTextField(0);
		JButton btn_submit = new JButton("Submit");

		btn_submit.addActionListener(e -> {
			txtInput_name.setEnabled(false);
			btn_submit.setEnabled(false);
			broadcastLabel.setText("WELCOME " + txtInput_name.getText());
			TicTacToeClient client = new TicTacToeClient();
			Thread T = new Thread(client);
			T.start();
		});

		inputLayout.add(txtInput_name);
		inputLayout.add(btn_submit);

		LayoutPanel.add(broadcastLabel, BorderLayout.NORTH);
		LayoutPanel.add(GameArea, BorderLayout.CENTER);
		LayoutPanel.add(inputLayout, BorderLayout.SOUTH);

//		add menu bar as well
		JMenuItem menuItem_Exit = new JMenuItem("Exit");
		JMenuItem menuItem_Instruction = new JMenuItem("Instruction");

		JMenu menu_control = new JMenu("Control");
		JMenu menu_help = new JMenu("Help");
		menu_control.add(menuItem_Exit);
		menu_help.add(menuItem_Instruction);

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu_control);
		menuBar.add(menu_help);

		// JFrame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(LayoutPanel);
		frame.setJMenuBar(menuBar);
		frame.setTitle("Tic Tac Toe");
		frame.setSize(500, 600);

//		// action listeners
		menuItem_Exit.addActionListener(e -> {
			frame.setVisible(false);
			frame.dispose();
		});

		menuItem_Instruction.addActionListener(e -> JOptionPane.showMessageDialog(frame, txtUtils.message()));

		frame.setVisible(true);
	}

}

