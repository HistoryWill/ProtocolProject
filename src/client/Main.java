package client;

import java.util.*;
import java.io.*;
import java.net.Socket;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static Socket socket;
	static DataInputStream input;
	static DataOutputStream output;
	final static int port = 1234;
	static String host = null;
	static String myName = null;
	
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
			output = new DataOutputStream(socket.getOutputStream());
			
			
		} catch (IOException e) {
			System.err.println(e);
		}
		
		/*
		 * client/server communication
		 */
		try {
			while (true) {
				String fromServer = input.readUTF();
				String[] split = fromServer.split(" ");
				if (fromServer != null && !split[0].equals(myName)) {
					System.out.println(fromServer);
				}
				String toServer = scan.nextLine();
				if (toServer != null) {
					output.writeUTF(myName+": "+toServer);
					output.flush();
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
}
