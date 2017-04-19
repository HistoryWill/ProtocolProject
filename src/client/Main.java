package client;

import java.util.*;
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
				System.out.println('E');
				if (toServer != null) {
					out.print(myName+": "+toServer);
					//output.flush();
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
}
