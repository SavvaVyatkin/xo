package xo.savva.strategies.com;

public class BoardHard extends Board {

	@Override
	public int move(String o2) {
		if (this.board[1][1].equals(" ")) {
			this.board[1][1] = o2;
			return 4;
		}
		
		// check corners 00 02 20 22 
		if (checkCorner (0,0,o2)) {
			this.board[0][0] = o2;
			return 0;
		}
		if (checkCorner (0,2,o2)) {
			this.board[0][2] = o2;
			return 2;
		}
		if (checkCorner (2,0,o2)) {
			this.board[2][0] = o2;
			return 6;
		}
		if (checkCorner (2,2,o2)) {
			this.board[2][2] = o2;
			return 8;
		}
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (this.board[i][j].equals(" ")) {
					this.board[i][j] = o2;
					return i*3 + j;
				}
		return 0;
	}

}
