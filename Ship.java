import java.util.ArrayList;
public class Ship {
	ArrayList<boardSpace> spaces = new ArrayList<boardSpace>();
	private int length;
	private int hp;
	private String name;
	public Ship(int length, String name) {
		this.length = length;
		this.hp = length;
		this.name = name;
	}
	public void addSpace(boardSpace x) {
		spaces.add(x);
		
	}
	
	
	
	public String getName() {
		return this.name;
	}
	
	public void whereAmI() {
		for(boardSpace e : spaces) {
			System.out.println(e.getXLocation() +" " + e.getYLocation());
		}
	}

	
	public boolean isDead() {
		int hits = 0;
		for(boardSpace e : spaces) {
			if(e.isHit() == "X") {
				hits += 1;
			}
		}
		return (this.hp == hits);
	}
	
	public boolean placesHit() {
		int timesHit = 0;
		for(boardSpace e : spaces) {
			if(e.isHit() == "X") {
				timesHit += 1;
			}
		}
		return (timesHit>0);
	}
	
	
}
