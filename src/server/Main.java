package server;

import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Queue;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {


    
    static ArrayList<ClientThread> clients = new ArrayList<>();

	final static int  portNumber = 1234;
	static ServerSocket serverSocket = null;
    static Socket socket = null;
    static Queue<String> messageStack = new LinkedList(); //This will act as the central message Depositroy

    
    public static void main(String args[]){
    	System.out.println("FUCK GIT3");
    	try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
    		System.out.println("FUCK GIT2");
    		while (true) {
    			try {
    				System.out.println("FUCK GIT1");
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
    		System.out.println(e);
    	}
    }
    
    

    
    

	public static void notifyAllOfMessage(String fromServer) {
		for(ClientThread client : clients) {
			System.out.println(clients.size());
			System.out.println(client);
			System.out.println("FUG");
			client.messageNotify(fromServer);
		}
	}
    


}


    


