package server;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	final static int  portNumber = 8080;
	static ServerSocket serverSocket = null;
    static Socket socket = null;
    static Queue<String> messageStack = new LinkedList(); //This will act as the central message Depositroy
    
    static ArrayList<ClientThread> clients = new ArrayList<>();
    
    public static void main(String args[]){
    	
    	try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
    	
    		while (true) {
    			try {
    				socket = serverSocket.accept();
        			// new thread for a client
    				ClientThread client = new ClientThread(socket); 
    				clients.add(client);
    				client.start();
    			} catch (IOException e) {
    				System.out.println("I/O error: " + e);
    			}
    		}
    	
    	} catch(IOException e){
    		
    	}
    }
    
    
    
    

	public static void notifyAllOfMessage(String fromServer) {
		for(ClientThread client : clients) {
			client.messageNotify(fromServer);
		}
	}
    


}
