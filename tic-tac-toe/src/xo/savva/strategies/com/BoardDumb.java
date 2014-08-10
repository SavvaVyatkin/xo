package xo.savva.strategies.com;

import java.util.Random;

public class BoardDumb extends Board {

	@Override
	public int move(String o2) {
		if (this.isBoardFull()) return -1;
		int i = 0,j = 0;
		int r;
		Random rn = new Random();		
		do {
			r = rn.nextInt(9);
			i = r / 3;
			j = r % 3;
		}
		while (board[i][j] != " ");
		this.board[i][j] = o2;

		return r;
	}

}
