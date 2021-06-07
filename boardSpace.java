public class boardSpace {
	private int xPos;
	private int yPos;
	private boolean hit;
	private boolean full;
	private String strong = "O";
	public boardSpace(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.hit = false;
	}
	public String toString() {
		return xPos + " // " + yPos + " // " + hit + " ";
		
		
	}
	
	public void setLetter(String x) {
		this.strong = x;
	}
	
	public String getLetter() {
		return this.strong;
	}
	
	
	
	
	
	
	public String isHit() {
		if(hit == true) {
			return "X";
		}
		else {
			return "O";
		}
	}
	
	public void changeFull(boolean newState) {
		this.full = newState;
	}
	
	public boolean isFull() {
		return this.full;
	}
	
	public int getXLocation() {
		return this.xPos;
	}
	public int getYLocation() {
		return this.yPos;
	}
	
	
	public void changeState(boolean newState) {
		this.hit = newState;
		
	}

}
