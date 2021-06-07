import java.io.IOException;
import java.util.Scanner;
import java.net.*;
public class playGame {
	private int numShots = 45;
	private String boardDone = "false";
	static GreetServer e = new GreetServer();
	static GreetClient client = new GreetClient();
	static private String type;
	
	public void getShot(battleshipBoard x) throws IOException {
		try {
			
			String pos = null;
			System.out.println("entering method");
			if(type == "S") {
				System.out.println("reading");
				pos = e.readMessage();
				while(pos.length() != 2) {
					pos = e.readMessage();
					}
				if(x.shipStates().contains("all")) {	
					e.stop();
					System.out.println("Game should be over");
					System.exit(0);
				}
			}
			if(type == "C") {
				System.out.println("reading");
				pos = client.readMessage();
				while(pos.length() != 2) {
					pos = client.readMessage();
					}
				if(x.shipStates().contains("all")) {	
					client.stopConnection();
					System.out.println("Game should be over");
					System.exit(0);
				}
				}
			
			
			String[] coordinates = pos.split("");
			System.out.println(pos.length());
			int xVal = stringToInt(coordinates[0]);
			System.out.println("Updating Board");
			x.hitSpace(Integer.parseInt(coordinates[1]), xVal);
			System.out.println("returning");
			if(x.returnFull(Integer.parseInt(coordinates[1]), xVal)) {
				if(type == "S") {
					e.sendMessage("HIT\n");
				}
				if(type == "C") {
					client.sendMessage("HIT\n");
				}
			}
			else {
				if(type == "S") {
					e.sendMessage("MISS\n");
				}
				if(type == "C") {
					client.sendMessage("MISS\n");
				}
			}
			
			//x.printBoard();
			this.numShots -= 1;
		}
		catch(java.lang.NullPointerException e) {
			System.out.println("E");
		}
		}
	
	
	public void shootEnemy(String pos, battleshipBoard x) throws IOException {
		if(type == "S") {
			e.sendMessage(pos);
			System.out.println("Shot Fired");
			while(true) {
				System.out.println("Awaiting response...");
				String status = e.readMessage();
				if(status.length() > 2) {
					System.out.println("Message recieved");
					System.out.println(status);
					String[] coordinates = pos.split("");
					int xVal = stringToInt(coordinates[0]);
					x.hitSpace(Integer.parseInt(coordinates[1]), xVal);
					break;
				}
			}
			
			
		}
		if(type == "C") {
			client.sendMessage(pos);
			System.out.println("Shot Fired");
			while(true) {
				System.out.println("Awaiting response...");
				String status = client.readMessage();
				if(status.length() > 2) {
					System.out.println("Message recieved");
					System.out.println(status);
					String[] coordinates = pos.split("");
					int xVal = stringToInt(coordinates[0]);
					x.hitSpace(Integer.parseInt(coordinates[1]), xVal);
					break;
				}
			}
		}
		
		
		
		
		
		
	}
	
	public playGame() {
		
	}
	

	
	
	public int shotsLeft() {
		return this.numShots;
	}
	
	
	public int stringToInt(String x) {
		if(x.toUpperCase().equals( "A")) {
			return 0;
		}
		if(x.toUpperCase().equals( "B")) {
			return 1;
		}
		if(x.toUpperCase().equals( "C")) {
			return 2;
		}
		if(x.toUpperCase().equals( "D")) {
			return 3;
		}
		if(x.toUpperCase().equals( "E")) {
			return 4;
		}
		if(x.toUpperCase().equals( "F")) {
			return 5;
		}
		if(x.toUpperCase().equals("G")) {
			return 6;
		}
		if(x.toUpperCase().equals("H")) {
			return 7;
		}
		if(x.toUpperCase().equals("I")) {
			return 8;
		}
		if(x.toUpperCase().equals("J")) {
			return 9;
		}
		else {
			return -1;
		}
		
		
	}
	
	public boolean verifyInput(String input) {
		String[] coord = input.split("");
		int ye = 0;
		playGame2 g = new playGame2();
		if(g.stringToInt(coord[0]) == -1) {
			ye -= 1;
		}
		else {
			ye += 1;
		}
		try {
			Integer.parseInt(coord[1]);
			ye += 1;
		} catch(NumberFormatException e) {
			ye -= 1;
		}
		if(ye == 2 && input.length() == 2) {
			return true;
		}
		else {
			return false;
		}
				
				
				
			
		
}
		

	
	
	
	

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("Welcome to Battleship");
		playGame2 game = new playGame2();
		Scanner input = new Scanner(System.in);
		battleshipBoard board = new battleshipBoard(10, 10);
		board.placeShips(board);
		battleshipBoard enemyBoard = new battleshipBoard(10, 10);
		board.printBoardLetters();
		while(true) {
			System.out.println("Do you want to rerandomize the board? ");
         String s = input.nextLine();
			if(s.toLowerCase().equals("no") || s.toLowerCase().equals("n")) {
				break;
				
				
			}
			else {
				board = new battleshipBoard(10, 10);
				board.placeShips(board);
				board.printBoardLetters();
				
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		while(true) {
         System.out.println("Are you the Server (S) or the Client (C)?");
			String input2 = input.nextLine();
			if(input2.toUpperCase().equals("S")) {
				type = "S";
				System.out.println("Ok, starting server");
				System.out.println("First Step Done");
				
				try(final DatagramSocket socket = new DatagramSocket()){
					  socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
					  System.out.println("the ip address of this server is: " + socket.getLocalAddress().getHostAddress());
					  }
				System.out.println("Server has spun up, please have the client connect");
				e.start(6666);
				break;
			}
			if(input2.toUpperCase().equals("C")) {
				type = "C";
            System.out.println("Input the IPv4 address of the server");
            String input3 = input.nextLine();
				System.out.println("Initiating");
			    client.startConnection(input3, 6666);
			    System.out.println("Connected");
				break;
			}
			else {
				System.out.println("Invalid Input");
			}
		
	}
		
		
		
		
	
		
		
		
		
		
		while(game.shotsLeft() > 0) {
			System.out.println("Shots Left: " + game.shotsLeft());
			if(type == "S") {
				while(true) {
					System.out.println("Place enter the coordinates of where you would like to shoot");
					String location = input.next();
					if(game.verifyInput(location) == true) {
						game.shootEnemy(location, enemyBoard);
						enemyBoard.printBoard();
					}
					System.out.println("Getting Shot");
					Thread.sleep(5000);
					game.getShot(board);
				}
			}
			if(type == "C") {
				while(true) {
					System.out.println("getting shot");
					Thread.sleep(5000);
					game.getShot(board);
					System.out.println("Place enter the coordinates of where you would like to shoot");
					String location = input.next();
					if(game.verifyInput(location) == true) {
						game.shootEnemy(location, enemyBoard);
						enemyBoard.printBoard();
					}
					
					
					
					
					
				}
			}
		}
		
		
	}
	
}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	