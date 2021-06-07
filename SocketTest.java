import java.io.IOException;
import java.util.Scanner;
public class SocketTest {
	private SocketClientTest client;
	
	public void setup() throws IOException {
		client = new SocketClientTest();
		client.startConnect("192.168.56.1", 4444);
	
	}
	
	public void terminate() throws IOException {
		client.terminateConnection();
	}
	
	
	public void testMethod() throws IOException {
	    String resp1 = client.sendData("hello");
	    String resp2 = client.sendData("world");
	    String resp3 = client.sendData("!");
	    String resp4 = client.sendData(".");
	    if(resp1.equals("hello") && resp2.equals("world") && resp3.equals("!") && resp4.equals(".")) {
	    	System.out.println("it worked lmao");
	    }
	    
	}
	
	
	

	
	public static void main(String[] args) throws IOException {
		SocketTest e = new SocketTest();
		
		System.out.println("y");
		
		
		
		
	}
	
	
	
	
	
	
	
}
