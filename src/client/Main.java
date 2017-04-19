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
	final static int port = 1234;
	static String host = null;
	static String inpu;
	static String myName = null;
	static PrintWriter out;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Enter the URL of the server.");
		host = scan.nextLine();
		
		/*
		 * connect to server
		 * initiate I/O streams
		 * establish user name
		 */
		try {
			socket = new Socket(host,port);
			input = new DataInputStream(socket.getInputStream());
			output = socket.getOutputStream();		
			out = new PrintWriter(output);
			
		} catch (IOException e) {
			System.err.println(e);
		}
    	
   		
    			ListeningThread client = new ListeningThread(socket); 
   
				client.start();
				System.out.println("Listening");
    		
		while(true){
			inpu = scan.nextLine();
			client.messageNotify(inpu);
			
			
		}
    	
	} 
	
	public static void notifyOfMessage(String x){
		System.out.println(x);
		
	}
	
	

}