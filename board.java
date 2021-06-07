public class board {
	private boardSpace[][] gameBoard;
	private int length;
	private int width;
	public board(int length, int width) {
		this.length = length;
		this.width = width;
		gameBoard = new boardSpace[this.length][this.width];
		for(int i = 0; i < this.length; i++) {
			for(int y = 0; y < this.width; y++) {
				gameBoard[i][y] = new boardSpace(i, y);
				
			}
		}
	}
	public void printBoard() {
		String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		System.out.println("  A  B  C  D  E  F  G  H  I  J ");
		for(int i = 0; i < gameBoard.length; i++) {
			System.out.print(i);
			for(int y = 0; y < gameBoard[i].length; y++) {
				System.out.print("{" + gameBoard[i][y].isHit() + "}");	
			}
			System.out.println();
		}
	}
	public String returnState(int x, int y) {
		return gameBoard[x][y].isHit();
		
	}	
	
	public void printBoardLetters() {
		for(int i = 0; i < gameBoard.length; i++) {
			for(int y = 0; y < gameBoard[i].length; y++) {
				System.out.print("{" + gameBoard[i][y].getLetter() + "}");	
			}
			System.out.println();
		}
	}
	
	public void setLetter(int x, int y, String z) {
		gameBoard[x][y].setLetter(z);
	}
	
	
	public int returnLength() {
		return this.length;
	}
	public int returnWidth() {
		return this.width;
	}
	
	public void hitSpace(int x, int y) {
		gameBoard[x][y].changeState(true);
	}
	
	
	public void fullSpace(int x, int y) {
		gameBoard[x][y].changeFull(true);
	}
	
	
	public boardSpace getSpace(int x, int y) {
		return gameBoard[x][y];
	}
	
	
	public boolean returnFull(int x, int y) {
		return gameBoard[x][y].isFull();
	}
}
