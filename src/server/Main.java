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