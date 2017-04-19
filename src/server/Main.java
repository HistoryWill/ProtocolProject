package server;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	final static int  portNumber = 1234;
	static ServerSocket serverSocket = null;
    static Socket socket = null;
    static Queue<String> messageStack = new LinkedList(); //This will act as the central message Depositroy
    
    static ArrayList<ClientThread> clients = new ArrayList<>();
    
    public static void main(String args[]){
    	System.out.println("Test Server");
    	try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
    	System.out.println("Helpa");
    		while (true) {
    			System.out.println("test");
    			try {
    				socket = serverSocket.accept();
        			// new thread for a client
    				ClientThread client = new ClientThread(socket); 
    				clients.add(client);
    				client.start();
    				System.out.println("Listening");
    			} catch (IOException e) {
    				System.out.println("I/O error: " + e);
    			}
    		}
    	
    	} catch(IOException e){
    		System.out.println(e);
    	}
    }
    
    
    
    

	public static void notifyAllOfMessage(String fromServer) {
		for(ClientThread client : clients) {
			client.messageNotify(fromServer);
		}
	}
    


}
