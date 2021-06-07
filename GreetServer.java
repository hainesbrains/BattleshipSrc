import java.net.*;
import java.io.*;
public class GreetServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        }

    public void sendMessage(String msg) {
    	out.println(msg);
    }
    public void sendMessage(boolean msg) {
    	out.println(msg);
    }
    public void sendMessage(int msg) {
    	out.println(msg);
    }
    
    public String readMessage() throws IOException {
    	return in.readLine();
    }
    	
    public void stop() throws IOException {
        System.out.println("Stopping");
    	in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    public static void main(String[] args) throws IOException {
        GreetServer server = new GreetServer();
        server.start(6666);
        System.out.println("Server Running");
    }
}