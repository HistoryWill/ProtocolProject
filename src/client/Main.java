package client;

import java.util.*;

import server.ClientThread;

import java.io.*;
import java.net.Socket;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static Socket socket;
	static DataInputStream input;
	static OutputStream output;
	final static int port = 1234;
	static String host = null;
	static String myName = null;
	static String line;
	static PrintWriter out;
	
	
	public static void main(String[] args) throws Exception {
		/*
		 * Asks the user for the Name of the host server.
		 * Uses Scanner to set the host to the next line entered by the user
		 */
		System.out.println("Enter the URL of the server.");
		host = scan.nextLine();
		
		/*
		 * Attempts to create a socket connected to the host and the pre-specified port number:1234
		 * Throws an exception if the socket cannot be created
		 */
		try {
			socket = new Socket(host,port);
		} catch (IOException CannotCreateSocket) {
			System.err.println(CannotCreateSocket);
		}
	
	
		/*
		 * Creates a new listening thread that waits for messages from the server 
		 * (see ListeningThread class for details). 
		 * Subsequently the thread is started 
		 */
		ListeningThread client = new ListeningThread(socket); 
		client.start();
		
		/*
		 * Asks the user to enter there preferred user name and then scans it from the next line
		 * entered by the user using the scanner. 
		 */
		System.out.println("Please Enter Chat Name");
		myName = scan.nextLine();
		
		/*
		 * This loop asks the user to enter a message, scans it in if it is entered, and then
		 * sends it to the ListenerThread. 
		 */
		while(true){
			System.out.println("Please Enter Message");
			line = scan.nextLine();
			client.messageNotify(line, myName);
			
			
		}
	}
	
	/*
	 * Handles printing incoming messages to the user
	 */
	 public static void MessageStater(String x){
		 System.out.println(x);
		 
	 }
	
	}
	

