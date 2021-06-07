import java.net.*;
import java.io.*;

public class SocketServerTest {

	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	public void spinUp(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			if(".".equals(inputLine)) {
				out.print("Cya");
				break;
			}
			out.println(inputLine);
		}
	}
		
		public static void main(String[] args) {
	        SocketServerTest thing = new SocketServerTest();
	        thing.spinUp(6666);
	    }
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
