import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;


public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50,50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setVisible(true);


        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
 
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);  // Also fixed spelling
        textfield.setText("Tic-Tac-Toe");  // Replaced setTitle with setText (likelo what oou meant)
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);



        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        firstTurn();

    }
    public void actionPerformed(ActionEvent e){

        for(int i =0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("o turn");
                        check();
                    }
                }
                else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("o");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }

    }
    public void firstTurn(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("X turn");
        }
        else{
            player1_turn=false;
            textfield.setText("o turn");
        }

    }
    public void check(){
        if((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))){
            xWins(0,1,2);
        }
        if((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))){
            xWins(3,4,5);
        }
        if((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X"))){
            xWins(6,7,8);
        }
        if((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X"))){
            xWins(0,3,6);
        }
        if((buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))){
            xWins(1,4,7);
        }
        if((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))){
            xWins(2,5,8);
        }
        if((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X"))){
            xWins(0,4,8);
        }
        if((buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X"))){
            xWins(2,4,6);
        }

        if((buttons[0].getText().equals("o")) && (buttons[1].getText().equals("o")) && (buttons[2].getText().equals("o"))){
            oWins(0,1,2);
        }
        if((buttons[3].getText().equals("o")) && (buttons[4].getText().equals("o")) && (buttons[5].getText().equals("o"))){
            oWins(3,4,5);
        }
        if((buttons[6].getText().equals("o")) && (buttons[7].getText().equals("o")) && (buttons[8].getText().equals("o"))){
            oWins(6,7,8);
        }
        if((buttons[0].getText().equals("o")) && (buttons[3].getText().equals("o")) && (buttons[6].getText().equals("o"))){
            oWins(0,3,6);
        }
        if((buttons[1].getText().equals("o")) && (buttons[4].getText().equals("o")) && (buttons[7].getText().equals("o"))){
            oWins(1,4,7);
        }
        if((buttons[2].getText().equals("o")) && (buttons[5].getText().equals("o")) && (buttons[8].getText().equals("o"))){
            oWins(2,5,8);
        }
        if((buttons[0].getText().equals("o")) && (buttons[4].getText().equals("o")) && (buttons[8].getText().equals("o"))){
            oWins(0,4,8);
        }
        if((buttons[2].getText().equals("o")) && (buttons[4].getText().equals("o")) && (buttons[6].getText().equals("o"))){
            oWins(2,4,6);
        }


    }
    public void xWins(int a,int b, int c){
        buttons[a].setBackground((Color.GREEN));
        buttons[b].setBackground((Color.GREEN));
        buttons[c].setBackground((Color.GREEN));
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Wins");




    }
    public void oWins(int a,int b, int c){
        buttons[a].setBackground((Color.GREEN));
        buttons[b].setBackground((Color.GREEN));
        buttons[c].setBackground((Color.GREEN));
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("o Wins");

    }
}
