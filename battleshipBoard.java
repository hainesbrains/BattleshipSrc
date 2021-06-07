import java.util.Random;
public class battleshipBoard extends board{
	private int[] shipLengths = new int[5];
	private Ship[] gameShips;
	private String[] letters = {"A", "B", "D", "S", "P"};
	public battleshipBoard(int length, int width) {
		super(length, width);
		
		
		
	}
	

	
	public String shipStates() {
		int r = 0;
		for(Ship e : gameShips) {
			if(e.isDead() == true) {
				System.out.println("You have sunk the enemy " + e.getName());
				r += 1;
			}
			else {
			}
			
		}
		if(r == 5) {
			return("You have destroyed all of the enemy ships");
		}
		else {
			return "You have " + (5-r) + " ships left to sink all";
		}
	}
	
	
	
	
	
	
	
	
	
	public void placeShips(battleshipBoard x) {
		Ship aircraft = new Ship(5, "aircraft carrier");
		Ship battleship = new Ship(4, "battleship");
		Ship destroyer = new Ship(3, "destroyer");
		Ship submarine = new Ship(2, "submarine");
		Ship patrol = new Ship(1, "patrol boat");
		this.gameShips = new Ship[] {aircraft, battleship, destroyer, submarine, patrol};
		int[] shipLengths = {5, 4, 3, 2, 1};
		Random rand = new Random();
		
		
		for(int i = 0; i < shipLengths.length; i++) {
			boolean done = false;
			
			start:
			while(!done) {
				boolean vertical = rand.nextBoolean();
				int col = rand.nextInt(x.returnLength());
				int row = rand.nextInt(x.returnLength());
				if(x.returnFull(row, col) == true) {
					continue;
				}
				if(vertical == true) {
					for(int e = 0; e < shipLengths[i]; e++) {
						if(x.returnFull(e+1, col) == true) {
							System.out.println("help");
							continue start;
						}
						else {
							x.setLetter(e+1, col, letters[i]);
							x.fullSpace(e+1, col);
							gameShips[i].addSpace(this.getSpace(e+1, col));
						}
					}
					
					
				}
				else {
					for(int e = 0; e < shipLengths[i]; e++) {
						if(x.returnFull(row, e+1) == true) {
							System.out.println("help");
							continue start;
						}
						else {
							x.setLetter(row, e+1, letters[i]);
							x.fullSpace(row, e+1);
							gameShips[i].addSpace(this.getSpace(row, e+1));
						}
					}
				}
				done = true;
			}

		}
	}
	
	public static void main(String[] args) {
		battleshipBoard b1 = new battleshipBoard(10, 10);
		b1.placeShips(b1);
		b1.printBoard();
		
		
	}
	
	
	
	
}
