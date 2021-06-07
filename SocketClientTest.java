import java.net.*;
import java.io.*;




public class SocketClientTest {

	
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	public void startConnect(String ip, int port) throws IOException{
		clientSocket = new Socket(ip, port);
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	
	
	public String sendData(String msg) throws IOException {
		out.println(msg);
		String resp = in.readLine();
		return resp;
	}
	
	
	public void terminateConnection() throws IOException {
		in.close();
		out.close();
		clientSocket.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
