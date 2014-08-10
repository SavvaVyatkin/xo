package xo.savva.com;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import xo.savva.strategies.com.Board;
import xo.savva.strategies.com.BoardHard;
import xo.savva.strategies.com.BoardInterface;

public class TicTacToe implements ActionListener {
	// makes buttons
	
	private JFrame window = new JFrame("Tic-Tac-Toe");
	private JButton button1 = new JButton("");
	private JButton button2 = new JButton("");
	private JButton button3 = new JButton("");
	private JButton button4 = new JButton("");
	private JButton button5 = new JButton("");
	private JButton button6 = new JButton("");
	private JButton button7 = new JButton("");
	private JButton button8 = new JButton("");
	private JButton button9 = new JButton("");
	private static ImageIcon image = new ImageIcon("");
	private static ImageIcon image2 = new ImageIcon("");
	private int count = 0;
	private boolean win = false;
	static BoardInterface bb;
	private boolean compWin = false;
	String whowins = "";

	public TicTacToe() {
		// makes JPanel
		window.setSize(300, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridLayout(3, 3));

		// Adds Buttons To JPanel
		window.add(button1);
		window.add(button2);
		window.add(button3);
		window.add(button4);
		window.add(button5);
		window.add(button6);
		window.add(button7);
		window.add(button8);
		window.add(button9);

		// makes buttons know if pressed
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);

		// makes JPanel visible
		window.setVisible(true);
	}
	public void gameOver() {
//		JOptionPane.showMessageDialog(null, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
//		JOptionPane.showMessageDialog(null, "Game Over");
		System.exit(0);
		}

	public void actionPerformed(ActionEvent event) {
		count++;

		int i = 0,j = 0;
		// displays if x or y
		if (event.getSource() == button1) {
			button1.setIcon(image);
			button1.setEnabled(false);
			i=0; j=0;
		} else if (event.getSource() == button2) {
			button2.setIcon(image);
			button2.setEnabled(false);
			i=0; j=1;
		} else if (event.getSource() == button3) {
			button3.setIcon(image);
			button3.setEnabled(false);
			i=0; j=2;
		} else if (event.getSource() == button4) {
			button4.setIcon(image);
			button4.setEnabled(false);
			i=1; j=0;
		} else if (event.getSource() == button5) {
			button5.setIcon(image);
			button5.setEnabled(false);
			i=1; j=1;
		} else if (event.getSource() == button6) {
			button6.setIcon(image);
			button6.setEnabled(false);
			i=1; j=2;
		} else if (event.getSource() == button7) {
			button7.setIcon(image);
			button7.setEnabled(false);
			i=2; j=0;
		} else if (event.getSource() == button8) {
			button8.setIcon(image);
			button8.setEnabled(false);
			i=2; j=1;
		} else if (event.getSource() == button9) {
			button9.setIcon(image);
			button9.setEnabled(false);
			i=2; j=2;
		}

		/**
		 * here we catch cheaters print the board and show who wins
		 */
		if (bb.getBoardElement(i, j).equals(" ")) {
			bb.setBoardElement(Board.X, i, j);
			if (bb.isWin()) {
//	Computer Lost
				compWin = true;
			} else {
				int m = bb.winMove(Board.O);
				if (m != -1) {
					printButton(m);
					win = true;
				} else {
					int mEnemyWin = bb.winEnemyMove(Board.X, Board.O);
					if (mEnemyWin == -1) {
						printButton(bb.move(Board.O));
					} else printButton(mEnemyWin);
				}
			}
			if (bb.isBoardFull())
				win = false;
		}
		// sees who wins
		if (win) {
			//Computer Wins!
			whowins = "Computer Wins!";
			question();
		} else if (compWin) {
			//You WIN!
			whowins = "You Win!";
			question();
		} else if (count == 5) {
			//Tie Game!
			whowins = "Tie Game!";
			question();
		}
}
	private void question() {
		int dialogButton = JOptionPane.showConfirmDialog (null, "Continue?", whowins, JOptionPane.YES_NO_OPTION);
		if(dialogButton == JOptionPane.NO_OPTION) {
		    System.exit(0);}
		continueGame();
		difficulty();
	}
	private static void selection(){
		Object possibleValues = XorO();
		if ("O".equals(possibleValues)) oSelected();
		if ("X".equals(possibleValues)) xSelected();
	}
	private static void difficulty(){
		Object possibleValues = Difficulty();
		if ("Medium".equals(possibleValues)) mediumDifficulty();
		if ("Hard".equals(possibleValues)) hardDifficulty();
		selection();
	}
	private static  void mediumDifficulty() {
		bb =  new Board();
	}
	private static void hardDifficulty() {
		bb = new BoardHard();
	}
	private void continueGame() {
		button1.setIcon(null);
		button1.setText("");
		button1.setEnabled(true);
		button2.setIcon(null);
		button2.setText("");
		button2.setEnabled(true);
		button3.setIcon(null);
		button3.setText("");
		button3.setEnabled(true);
		button4.setIcon(null);
		button4.setText("");
		button4.setEnabled(true);
		button5.setIcon(null);
		button5.setText("");
		button5.setEnabled(true);
		button6.setIcon(null);
		button6.setText("");
		button6.setEnabled(true);
		button7.setIcon(null);
		button7.setText("");
		button7.setEnabled(true);
		button8.setIcon(null);
		button8.setText("");
		button8.setEnabled(true);
		button9.setIcon(null);
		button9.setText("");
		button9.setEnabled(true);
		bb.clear();
		count=0;
		win = false;
		compWin = false;
	}
	private static void oSelected(){
		image =new ImageIcon("images/0.jpg");
		image2 = new ImageIcon("images/x.jpg");
	}
	private static void xSelected(){
		image = new ImageIcon("images/x.jpg");
		image2 = new ImageIcon("images/0.jpg");
	}

	private static Object XorO() {
		Object[] possibleValues = { "X", "O" };
		Object selectedValue = JOptionPane.showInputDialog(null,
		"Select Who To Play With", "Input",
		JOptionPane.INFORMATION_MESSAGE, null,
		possibleValues, possibleValues[0]);
		return selectedValue;
	}
	private static Object Difficulty() {
		Object[] possibleValues = { "Medium", "Hard" };
		Object selectedValue = JOptionPane.showInputDialog(null,
		"Select Difficulty", "Input",
		JOptionPane.INFORMATION_MESSAGE, null,
		possibleValues, possibleValues[0]);
		return selectedValue;
	}

	private void printButton(int m) {
		switch (m){
		case 0: 
			button1.setText(Board.O);
			button1.setIcon(image2);
			button1.setEnabled(false);
			break;
		case 1: 
			button2.setText(Board.O);
			button2.setIcon(image2);
			button2.setEnabled(false);
			break;
		case 2: 
			button3.setText(Board.O);
			button3.setIcon(image2);
			button3.setEnabled(false);
			break;
		case 3: 
			button4.setText(Board.O);
			button4.setIcon(image2);
			button4.setEnabled(false);
			break;
		case 4: 
			button5.setText(Board.O);
			button5.setIcon(image2);
			button5.setEnabled(false);
			break;
		case 5: 
			button6.setText(Board.O);
			button6.setIcon(image2);
			button6.setEnabled(false);
			break;
		case 6: 
			button7.setText(Board.O);
			button7.setIcon(image2);
			button7.setEnabled(false);
			break;
		case 7: 
			button8.setText(Board.O);
			button8.setIcon(image2);
			button8.setEnabled(false);
			break;
		case 8: 
			button9.setText(Board.O);
			button9.setIcon(image2);
			button9.setEnabled(false);
			break;
	}
	}

	public static void main(String[] args) {
		difficulty();
		new TicTacToe();
	}
}
