package server;

import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/*
 * @author Will
 * @author JR
 */
public class Main {
	/*
	 * clients: list of clients
	 */
    static ArrayList<ClientThread> clients = new ArrayList<>();
	final static int  portNumber = 1234;
	static ServerSocket serverSocket = null;
    static Socket socket = null;

    
    public static void main(String args[]){
    	
    	System.out.println("Server Started");
    	try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
    	
    		while (true) {
    			try {
    			
    				socket = serverSocket.accept();
        			// new thread for a client
    				ClientThread client = new ClientThread(socket); 
    				clients.add(client);
    				client.start();
    			} catch (IOException e) {
    				System.out.println("Client Error");
    			}
    		}
    	
    	} catch(IOException e){
    		System.out.println("Server Socket Error");
    	}
    }
    
    

    
    

	public static void notifyAllOfMessage(String fromServer) {
		for(ClientThread client : clients) {
		//	System.out.println(clients.size());
			//System.out.println(client);
		//	System.out.println("FUG");
			client.messageNotify(fromServer);
		}
	}
    


}


    


