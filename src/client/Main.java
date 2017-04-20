package client;

import java.util.*;

import server.ClientThread;

import java.io.*;
import java.net.*;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static Socket socket;
	final static int port = 8080;
	static DataInputStream input;
<<<<<<< HEAD
	static DataOutputStream output;
=======
	static OutputStream output;
	final static int port = 1234;
	static String host = null;
	static String myName = null;
	static String line;
	static PrintWriter out;
>>>>>>> refs/remotes/origin/master
	
	public static void main(String[] args) throws Exception{
		System.out.println("Please enter the server ip.");
		String connectIp = scan.nextLine();
		
		//setup
		try {
<<<<<<< HEAD
			socket = new Socket(connectIp, port);
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
		}	catch (IOException e) {
=======
			socket = new Socket(host,port);
			
			
		} catch (IOException e) {
>>>>>>> refs/remotes/origin/master
			System.err.println(e);
		}
		System.out.println("FUCK GIT1");
		
<<<<<<< HEAD
		//I/O
		while (true) {
			String received = input.readUTF();
			String toSend = scan.nextLine();
			System.out.println(received);
			output.writeUTF(toSend);
=======
		// new thread for a client
		ListeningThread client = new ListeningThread(socket); 
		
		client.start();
		
		while(true){
			line = scan.nextLine();
			client.messageNotify(line);
			
			
>>>>>>> refs/remotes/origin/master
		}
	}
	 public static void fuckgit(String x){
		 System.out.println(x);
		 
	 }
	
	}
	

