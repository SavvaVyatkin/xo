package xo.savva.strategies.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Savva Vyatkin
 * 
 */
public class Board implements BoardInterface {

	/**
	 * Game Tic Tac Toe
	 */
	public static String O = "O";
	public static String X = "X";
	/**
	 * board - contains board 3x3
	 */
	protected String[][] board = new String[3][3];
	{
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board[i][j] = " ";
	}
	
	public void clear() {
		{
			for (int i = 0; i < 3; i++)
				for (int j = 0; j < 3; j++)
					this.board[i][j] = " ";
		}
	}

	public Board() {
		super();
	}

	public Board(String[][] board) {
		super();
		this.board = board;
	}

	/**
	 * 
	 * @param i
	 *            - check column #i
	 * @return - true if full up with the same player code
	 */

	private boolean checkColumn(int i) {
		String s = this.board[0][i] + this.board[1][i] + this.board[2][i];
		if ((s).equalsIgnoreCase("OOO"))
			return true;
		if ((s).equalsIgnoreCase("XXX"))
			return true;
		return false;
	}

	/**
	 * 
	 * @param i
	 *            - row
	 * @param j
	 *            - column
	 * @param x2
	 *            - X or O
	 * @param b
	 *            - current board
	 * @return true if its i and j - win code
	 */

	private boolean isWinMove(int i, int j, String x2, BoardInterface b) {
		if (b.getBoardElement(i, j).equals(" ")) {
			b.setBoardElement(x2, i, j);
			if (b.isWin())
				return true;
		}
		return false;
	}

	/**
	 * override clone method
	 */

	@Override
	protected BoardInterface clone() {
		String[][] deffendsCopy = new String[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				deffendsCopy[i][j] = this.board[i][j];
		return new Board(deffendsCopy);

	}

	/* (non-Javadoc)
	 * @see xo.com.BoardInterface#winMove(java.lang.String)
	 */

	@Override
	public int winMove(String o2) {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (this.board[i][j] == " ")
					if (isWinMove(i, j, o2, this.clone())) {
						this.board[i][j] = o2;
						return i*3 + j;
					}
		return -1;
	}

	/* (non-Javadoc)
	 * @see xo.com.BoardInterface#winEnemyMove(java.lang.String, java.lang.String)
	 */
	@Override
	public int winEnemyMove(String x2, String o2) {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (this.board[i][j] == " ")
					if (isWinMove(i, j, x2, this.clone())) {
						this.board[i][j] = o2;
						return i*3 + j;
					}
		return -1;
	}

	/**
	 * 
	 * @return false if the board has pieces
	 */
	private boolean isBoardEmpty() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (this.board[i][j] != " ")
					return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see xo.com.BoardInterface#isBoardFull()
	 */
	@Override
	public boolean isBoardFull() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (this.board[i][j].equals(" "))
					return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see xo.com.BoardInterface#isWin()
	 */
	@Override
	public boolean isWin() {
		for (int i = 0; i < 3; i++) {
			if (checkColumn(i))
				return true;
			if (checkRow(i))
				return true;
		}
		if (checkDiagnol1())
			return true;
		if (checkDiagnol2())
			return true;
		return false;
	}

	/**
	 * 
	 * @param i
	 *            represents the row
	 * @return true if there is a win on the rows
	 */
	private boolean checkRow(int i) {
		String s = this.board[i][0] + this.board[i][1] + this.board[i][2];
		if ((s).equalsIgnoreCase("OOO"))
			return true;
		if ((s).equalsIgnoreCase("XXX"))
			return true;
		return false;
	}

	/**
	 * 
	 * @return true if there is a win on the first diagnol
	 */
	private boolean checkDiagnol1() {
		String s = this.board[0][0] + this.board[1][1] + this.board[2][2];
		if ((s).equalsIgnoreCase("OOO"))
			return true;
		if ((s).equalsIgnoreCase("XXX"))
			return true;
		return false;
	}

	/**
	 * 
	 * @return true if there is a win on the second diagnol
	 */
	private boolean checkDiagnol2() {
		String s = this.board[0][2] + this.board[1][1] + this.board[2][0];
		if ((s).equalsIgnoreCase("OOO"))
			return true;
		if ((s).equalsIgnoreCase("XXX"))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see xo.com.BoardInterface#getBoard()
	 */
	@Override
	public String[][] getBoard() {
		return board;
	}

	/* (non-Javadoc)
	 * @see xo.com.BoardInterface#setBoard(java.lang.String[][])
	 */
	@Override
	public void setBoard(String[][] board) {
		this.board = board;
	}

	/* (non-Javadoc)
	 * @see xo.com.BoardInterface#getBoardElement(int, int)
	 */
	@Override
	public String getBoardElement(int i, int j) {
		return board[i][j];
	}

	/* (non-Javadoc)
	 * @see xo.com.BoardInterface#setBoardElement(java.lang.String, int, int)
	 */
	@Override
	public void setBoardElement(String x2, int i, int j) {
		this.board[i][j] = x2;
	}

	/* (non-Javadoc)
	 * @see xo.com.BoardInterface#move(java.lang.String)
	 */
	@Override
	public int move(String o2) {
		if (this.board[1][1].equals(" ")) {
			this.board[1][1] = o2;
			return 4;
		}
		
//		// check corners 00 02 20 22 
//		if (checkCorner (0,0,o2)) {
//			this.board[0][0] = o2;
//			return 0;
//		}
//		if (checkCorner (0,2,o2)) {
//			this.board[0][2] = o2;
//			return 2;
//		}
//		if (checkCorner (2,0,o2)) {
//			this.board[2][0] = o2;
//			return 6;
//		}
//		if (checkCorner (2,2,o2)) {
//			this.board[2][2] = o2;
//			return 8;
//		}
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (this.board[i][j].equals(" ")) {
					this.board[i][j] = o2;
					return i*3 + j;
				}
		return 0;
	}

	protected boolean checkCorner(int i, int j, String o2) {
		if (this.board[i][j].equals(" ")) return true;
		return false;
	}
//	
//	private boolean checkCorner(int i, int j, String o2) {
//		if (!this.board[i][j].equals(" ")) return false;
//		if (checkRow(i, o2) && checkColumn(j, o2)) return true;
//		return false;
//	}

	private boolean checkColumn(int j, String o2) {
		String enemy = (o2.equals(X)) ? O : X;
		int ecount = 0;
		for (int k=0; k < 3; k++) {
			if(board[k][j].equals(enemy)) ecount++;
			if(board[k][j].equals(o2)) return false;
		}
		
		return ecount==1;
	}

	private boolean checkRow(int i, String o2) {
		String enemy = (o2.equals(X)) ? O : X;
		int ecount = 0;
		for (int k=0; k < 3; k++) {
			if(board[i][k].equals(enemy)) ecount++;
			if(board[i][k].equals(o2)) return false;
		}
		
		return ecount==1;
	}

	/* (non-Javadoc)
	 * @see xo.com.BoardInterface#toString()
	 */

	@Override
	public String toString() {
		String s;

		s = board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "\n";
		s += "------" + "\n";
		s += board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "\n";
		s += "------" + "\n";
		s += board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "\n";
		return s;
	}

	static String getReadLine() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		return bufferedReader.readLine();
	}
}
