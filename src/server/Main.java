package server;

import java.util.*;
import java.io.*;
import java.net.*;

public class Main {
	final static int port = 8080;
	static ServerSocket serverSocket;
	static Socket socket;
	static HashSet<ClientThread> threads = new HashSet<ClientThread>();
	static Queue<String> messages = new PriorityQueue<String>();
	static InetAddress ip;
	static DataOutputStream output;
	
	public static void main(String[] args) throws Exception {
		ip = InetAddress.getLocalHost();
		
		//start
		serverSocket = new ServerSocket(port);
		System.out.println("Server started.\nAddress: "+ip);
		
		//COMMUNICATE
		while (true) {
			//check for new clients and set up output
			socket = serverSocket.accept();
			try {
				output = new DataOutputStream(socket.getOutputStream());
			}	catch (IOException e) {
				System.err.println(e);
			}
			ClientThread client = new ClientThread(socket);
			if (!threads.contains(client)) {
				threads.add(client);
			}
			
			//handle I/O
			Iterator<ClientThread> it = threads.iterator();
			while (it.hasNext()) {
				ClientThread thisClient = it.next();
				String toSend = null;
				if (!messages.isEmpty()) {
					toSend = messages.remove();
				}
				messages.add(thisClient.messages.remove());
				output.writeUTF(toSend);
			}
		}

}}
=======
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
    				System.out.println("I/O error: " + e);
    			}
    		}
    	
    	} catch(IOException e){
    		System.out.println(e);
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


    


>>>>>>> refs/remotes/origin/master
