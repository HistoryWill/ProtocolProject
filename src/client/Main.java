package client;

import java.util.*;
import java.io.*;
import java.net.*;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static Socket socket;
	final static int port = 8080;
	static DataInputStream input;
	static DataOutputStream output;
	
	public static void main(String[] args) throws Exception{
		System.out.println("Please enter the server ip.");
		String connectIp = scan.nextLine();
		
		//setup
		try {
			socket = new Socket(connectIp, port);
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
		}	catch (IOException e) {
			System.err.println(e);
		}
		
		//I/O
		while (true) {
			String received = input.readUTF();
			String toSend = scan.nextLine();
			System.out.println(received);
			output.writeUTF(toSend);
		}
	}
	
}
