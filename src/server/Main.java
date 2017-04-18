package server;

import java.util.*;
import java.io.*;
import java.net.*;

public class Main {
	final static int port = 1234;
	static ServerSocket serverSocket;
	static Socket socket;
	static HashSet<Socket> sockets = new HashSet<Socket>();
	
	public static void main(String[] args) {
		//startup
		System.out.println("Server started.");
		
		
		/*
		 * for running multiple clients
		 */
		class ClientThread{
			Socket socket;
			DataInputStream input;
			DataOutputStream output;
			Queue<String> messages = new PriorityQueue<String>();
			
			public ClientThread(Socket s){
				this.socket = s;
			}
			
			public void run() {
				
				//create I/O streams
				try {
					input = new DataInputStream(socket.getInputStream());
					output = new DataOutputStream(socket.getOutputStream());
				}	catch (IOException e) {
					System.err.println(e);
				}
				
				//communicate with clients
				while (true) {
					try {
						String fromClient = input.readUTF();
						String toClient = null;
						if (!fromClient.equals(null)) {
							messages.add(fromClient);
						}
						if (!messages.isEmpty()) {
							toClient = messages.remove();
						}
						if (!toClient.equals(null)) {
							output.writeUTF(toClient);
						}
					} catch (IOException e) {
						System.err.println(e);
					}
				}
			}
			
			
		}
		
		/*
		 * Establish the server
		 */
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.err.println(e);
		}
		
		/*
		 * Connect clients
		 */
		while (true) {
			try {
				socket = serverSocket.accept();
				if (!sockets.contains(socket)) {
					sockets.add(socket);
					System.out.println("Client connected.");
				}
			}	catch (IOException e) {
				System.err.println(e);
			}
			new ClientThread(socket).run();
		}
	}
	
	
	
}