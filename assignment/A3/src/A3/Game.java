package A3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.System.*;

public class Game {
    private int money = 100;
    private int bet = 0;
    private int changeTimes = 0;

    String [] deck = {"card_11", "card_12", "card_13", "card_14", "card_15", "card_16",
            "card_17", "card_18", "card_19", "card_110", "card_111", "card_112", "card_113",
            "card_21", "card_22", "card_23", "card_24", "card_25", "card_26", "card_27",
            "card_28", "card_29", "card_210", "card_211", "card_212", "card_213", "card_31",
            "card_32", "card_33", "card_34", "card_35", "card_36", "card_37", "card_38",
            "card_39", "card_310", "card_311", "card_312", "card_313", "card_41", "card_42",
            "card_43", "card_44", "card_45", "card_46", "card_47", "card_48", "card_49",
            "card_410", "card_411", "card_412", "card_413"};
    ArrayList<String> cardDeck = new ArrayList<String>();


    JLabel label_Image1 = new JLabel();
    JLabel label_Image2 = new JLabel();
    JLabel label_Image3 = new JLabel();
    JLabel label_Image4 = new JLabel();
    JLabel label_Image5 = new JLabel();
    JLabel label_Image6 = new JLabel();

    JButton btn_rpcard1 = new JButton("Replace Card 1");
    JButton btn_rpcard2 = new JButton("Replace Card 2");
    JButton btn_rpcard3 = new JButton("Replace Card 3");
    JButton btn_start = new JButton("Start");
    JButton btn_result = new JButton("Result");

    JLabel label_bet = new JLabel("Bet: $");
    JLabel label_info = new JLabel("Please place your bet! ");
    JLabel label_money = new JLabel("Amount of money you have: $" + this.getMoney());

    JTextField txt_inputbet = new JTextField(10);

    ImageIcon card_back = new ImageIcon("images/card_back.gif");
    ImageIcon image1 = card_back;
    ImageIcon image2 = card_back;
    ImageIcon image3 = card_back;
    ImageIcon image4 = card_back;
    ImageIcon image5 = card_back;
    ImageIcon image6 = card_back;

    public void go(){
        ArrayList<String> compare = new ArrayList<String>();

        cardDeck.addAll(Arrays.asList(deck));
        Collections.shuffle(cardDeck);

        this.label_Image1.setIcon(image1);
        this.label_Image2.setIcon(image2);
        this.label_Image3.setIcon(image3);
        this.label_Image4.setIcon(image4);
        this.label_Image5.setIcon(image5);
        this.label_Image6.setIcon(image6);

        JPanel MainPanel = new JPanel();
        JPanel DealerPanel = new JPanel();
        JPanel PlayerPanel = new JPanel();
        JPanel RpCardBtnPanel = new JPanel();
        JPanel ButtonPanel = new JPanel();
        JPanel InfoPanel = new JPanel();

        DealerPanel.add(label_Image1);
        DealerPanel.add(label_Image2);
        DealerPanel.add(label_Image3);
        PlayerPanel.add(label_Image4);
        PlayerPanel.add(label_Image5);
        PlayerPanel.add(label_Image6);
        RpCardBtnPanel.add(btn_rpcard1);
        RpCardBtnPanel.add(btn_rpcard2);
        RpCardBtnPanel.add(btn_rpcard3);
        ButtonPanel.add(label_bet);
        ButtonPanel.add(txt_inputbet);
        ButtonPanel.add(btn_start);
        ButtonPanel.add(btn_result);
        InfoPanel.add(label_info);
        InfoPanel.add(label_money);

        MainPanel.setLayout(new GridLayout(5,1));
        MainPanel.add(DealerPanel);
        MainPanel.add(PlayerPanel);
        MainPanel.add(RpCardBtnPanel);
        MainPanel.add(ButtonPanel);
        MainPanel.add(InfoPanel);

        DealerPanel.setBackground(Color.green);
        PlayerPanel.setBackground(Color.green);
        RpCardBtnPanel.setBackground(Color.green);

        JMenuBar manuBar = new JMenuBar();
        JMenu control = new JMenu("Control");
        JMenuItem quit = new JMenuItem("Quit");

        control.add(quit);
        manuBar.add(control);

        btn_result.setEnabled(false);
        btn_rpcard1.setEnabled(false);
        btn_rpcard2.setEnabled(false);
        btn_rpcard3.setEnabled(false);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(manuBar);
        frame.getContentPane().add(MainPanel);
        frame.setSize(400,700);
        frame.setVisible(true);

        quit.addActionListener(e -> System.exit(0));

        btn_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetChangeTimes();
                Collections.shuffle(cardDeck);
                compare.clear();
                if (txt_inputbet.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "You need at least bet $1");
                }else{
                    setMoney(txt_inputbet.getText(), 0);
                    if (getMoney() < 0){
                        JOptionPane.showMessageDialog(null, "Game over!\nYou have no more money!\nPlease start a new game");
                        System.exit(0);
                    }
                    label_info.setText("Your current bet is $" + txt_inputbet.getText());
                    label_money.setText("Amount money you have is $" + getMoney());
                    compare.add(cardDeck.get(3));
                    compare.add(cardDeck.get(4));
                    compare.add(cardDeck.get(5));
                    //System.out.println(compare);
                    label_Image1.setIcon(card_back);
                    label_Image2.setIcon(card_back);
                    label_Image3.setIcon(card_back);
                    label_Image4.setIcon(new ImageIcon("images/"+ cardDeck.get(3) + ".gif"));
                    label_Image5.setIcon(new ImageIcon("images/"+ cardDeck.get(4) + ".gif"));
                    label_Image6.setIcon(new ImageIcon("images/"+ cardDeck.get(5) + ".gif"));
                    btn_rpcard1.setEnabled(true);
                    btn_rpcard2.setEnabled(true);
                    btn_rpcard3.setEnabled(true);
                    btn_result.setEnabled(true);
                }
            }
        });

        btn_rpcard1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incrementChangeTimes();
                if (getChangeTimes() < 2){
                    compare.set(0, cardDeck.get(6));
                    label_Image4.setIcon(new ImageIcon("images/"+ cardDeck.get(6) + ".gif"));
                    btn_rpcard1.setEnabled(false);
                }else{
                    btn_rpcard1.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Sorry!\nYou can only replace twice!");
                }
            }
        });

        btn_rpcard2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incrementChangeTimes();
                if (getChangeTimes() <= 2){
                    compare.set(1, cardDeck.get(7));
                    label_Image5.setIcon(new ImageIcon("images/"+ cardDeck.get(7) + ".gif"));
                    btn_rpcard2.setEnabled(false);
                }else{
                    btn_rpcard2.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Sorry!\nYou can only replace twice!");
                }
            }
        });

        btn_rpcard3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incrementChangeTimes();
                if (getChangeTimes() <= 2){
                    compare.set(2, cardDeck.get(8));
                    label_Image6.setIcon(new ImageIcon("images/"+ cardDeck.get(8) + ".gif"));
                    btn_rpcard3.setEnabled(false);
                }else{
                    btn_rpcard3.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Sorry!\nYou can only replace twice!");
                }
            }
        });

        btn_result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compare.add(cardDeck.get(0));
                compare.add(cardDeck.get(1));
                compare.add(cardDeck.get(2));
                //System.out.println(compare);
                label_Image1.setIcon(new ImageIcon("images/"+ cardDeck.get(0) + ".gif"));
                label_Image2.setIcon(new ImageIcon("images/"+ cardDeck.get(1) + ".gif"));
                label_Image3.setIcon(new ImageIcon("images/"+ cardDeck.get(2) + ".gif"));
                Winner win = new Winner();
                String winner = win.getWinner(compare);
                if (winner.equals("Dealer")){
                    JOptionPane.showMessageDialog(null, "Sorry! The Dealer wins this round!");
                }else{
                    JOptionPane.showMessageDialog(null, "Congratulations! You win this round!");
                    setMoney(String.valueOf(getMoney() * 2),1);
                }
            }
        });
    }

    public int getMoney(){
        return this.money;
    }

    public void setMoney(String money, int status){
        if (status == 0){
            this.money = this.money - Integer.parseInt(money);
        }else{
            this.money = this.money + Integer.parseInt(money);
        }
    }

    public void resetChangeTimes(){
        this.changeTimes = 0;
    }

    public void incrementChangeTimes(){
        this.changeTimes = this.changeTimes + 1;
    }

    public int getChangeTimes(){
        return this.changeTimes;
    }
}
