package client;

import java.util.*;

import server.ClientThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static Socket socket;
	static DataInputStream input;
	static OutputStream output;
	final static int portNumber = 1234;
	static String host = null;
	static String myName = null;
	static PrintWriter out;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Enter the URL of the server.");
		host = scan.nextLine();
		//System.out.println("Test Server");
    	try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
    	System.out.println("Helpa");
    	
    			
    			try {
    				socket = serverSocket.accept();
        			// new thread for a client
    				ListeningThread client = new ListeningThread(socket); 
    				
    				client.start();
    				
    			} catch (IOException e) {
    				System.out.println("I/O error: " + e);
    			}
    		
    	
    	} catch(IOException e){
    		System.out.println(e);
    	}
	}
	
	public static void NotifyOfTraffic(String message){
		System.out.println(message);
		
	}
}
