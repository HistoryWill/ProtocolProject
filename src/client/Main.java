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
		System.out.println("Enter the URL of the server.");
		host = scan.nextLine();
		
		/*
		 * connect to server
		 * initiate I/O streams
		 * establish user name
		 */
		try {
			socket = new Socket(host,port);
			
			
		} catch (IOException e) {
			System.err.println(e);
		}
	
	
		// new thread for a client
		ListeningThread client = new ListeningThread(socket); 
		
		client.start();
		System.out.println("Please Enter Chat Name");
		myName = scan.nextLine();
		
		while(true){
			System.out.println("Please Enter Message");
			line = scan.nextLine();
			client.messageNotify(line, myName);
			
			
		}
	}
	 public static void MessageStater(String x){
		 System.out.println(x);
		 
	 }
	
	}
	

