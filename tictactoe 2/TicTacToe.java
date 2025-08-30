import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    static int boardWidth = 600;
    static int boardHeight = 650;

    static JFrame frame = new JFrame("TIC-TAC-TOE");
    static JLabel textLabel = new JLabel();
    static JPanel textPanel = new JPanel();
    static JPanel boardPanel = new JPanel();

    static JButton[][] board = new JButton[3][3];
    static String playerX = "X";
    static String playerO = "O";
    static String currentPlayer = playerX;

    static boolean gameOver = false;

    static int turns = 0;

    static JButton playAgainButton = new JButton("Reset");

    public static void main(String[] args){
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.DARK_GRAY);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("TIC-TAC-TOE");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        playAgainButton.setFont(new Font("Arial", Font.BOLD, 30));
        playAgainButton.setBackground(Color.white);
        playAgainButton.setFocusable(false);
        playAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                resetBoard();
                            }
                        });
                
                        JPanel buttonPanel = new JPanel();
                        buttonPanel.setLayout(new BorderLayout());
                        buttonPanel.add(playAgainButton, BorderLayout.CENTER);
                        frame.add(buttonPanel, BorderLayout.SOUTH);
                
                        for(int i = 0; i < 3; i++){
                            for(int k = 0; k < 3; k++){
                                JButton tile = new JButton();
                                board[i][k] = tile;
                                boardPanel.add(tile);
                
                                tile.setBackground(Color.darkGray);
                                tile.setOpaque(true);
                                tile.setForeground(Color.white);
                                tile.setFont(new Font("Arial", Font.BOLD, 120));
                                tile.setFocusable(false);
                                tile.setBorderPainted(true);
                                tile.setBorder(BorderFactory.createLineBorder(Color.white, 2));
                                tile.repaint();
                                //tile.setText(currentPlayer);
                
                                tile.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e){
                                        if(gameOver) return;
                                        JButton tile = (JButton) e.getSource();
                                        if(tile.getText() == ""){
                                            tile.setText(currentPlayer);
                                            turns++;
                                            checkWinner();
                                            if(!gameOver){
                                                currentPlayer = currentPlayer == playerX ? playerO : playerX;
                                                textLabel.setText(currentPlayer + " 's turn!");
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }
                
                    static void checkWinner(){
                        for(int i = 0; i < 3; i++){
                            if(board[i][0].getText() == "") continue;
                
                            if(board[i][0].getText() == board[i][1].getText() && board[i][1].getText() == board[i][2].getText()){
                                for(int k = 0; k < 3; k++){
                                    setWinner(board[i][k]);
                                                                    }
                                                                    gameOver = true;
                                                                    return;
                                                                }
                                                            }
                                                    
                                                            for(int c = 0; c < 3; c++){
                                                                if(board[0][c].getText() == "")continue;
                                                    
                                                                if(board[0][c].getText() == board[1][c].getText() && board[1][c].getText() == board[2][c].getText()){
                                                                    for(int r = 0; r < 3; r++){
                                                                        setWinner(board[r][c]);
                                                                    }
                                                                    gameOver = true;
                                                                    return;
                                                                }
                                                            }
                                                    
                                                            if(board[0][0].getText() == board[1][1].getText() && board[1][1].getText() == board[2][2].getText() && board[0][0].getText() != ""){
                                                                for(int i = 0; i < 3; i++){
                                                                    setWinner(board[i][i]);
                                                                }
                                                                gameOver = true;
                                                                return;
                                                            }
                                                    
                                                            if(board[0][2].getText() == board[1][1].getText() && board[1][1].getText() == board[2][0].getText() && board[0][2].getText() != ""){
                                                                setWinner(board[0][2]);
                                                                setWinner(board[1][1]);
                                                                setWinner(board[2][0]);
                                                                gameOver = true;
                                                                return;
                                                            }
                                                    
                                                            if(turns == 9){
                                                                for(int i = 0; i < 3; i++){
                                                                    for(int k = 0; k < 3; k++){
                                                                        setTie(board[i][k]);
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                        gameOver = true;
                                                                                                                                    }
                                                                                                                            
                                                                                                                                }
                                                                                                                            
                                                                                                                                static void setWinner(JButton tile){
                                                                                                tile.setForeground(Color.green);
                                                                                                tile.setBackground(Color.gray);
                                                                                                textLabel.setText(currentPlayer + " Wins!!");
                                                                                            }
                                                                                        
                                                                                            static void setTie(JButton tile){
                        tile.setForeground(Color.orange);
                        tile.setBackground(Color.gray);
                        textLabel.setText("DRAW!");
                    }
                
                    static void resetBoard(){
        for(int i = 0; i < 3; i++){
            for(int k = 0; k < 3; k++){
                board[i][k].setText("");
                board[i][k].setBackground(Color.darkGray);
                board[i][k].setForeground(Color.white);
            }
        }
        currentPlayer = playerX;
        gameOver = false;
        turns = 0;
        textLabel.setText("TIC-TAC-TOE");
    }
}
