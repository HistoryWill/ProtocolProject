package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {
	public static Scanner scan = new Scanner(System.in);
	public static Socket socket;
	public static int port = 8080;
	public static InputStream is;
	public static ObjectOutputStream os;
	
	public static void main(String[] args) throws Exception{
		System.out.println("Enter the url for the server.");
		String connection = scan.nextLine();
		

		try {
			//connect
			socket = new Socket(connection,port);
			
			//establish input/output streams
			is = new ObjectInputStream(socket.getInputStream());
			os = new ObjectOutputStream(socket.getOutputStream());
			
			//communicate
			while (true) {
				String message = (String)is.read();
				sendMessage(message);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		
	}
	
	public static void sendMessage(String message) {
		try {
			os.writeObject(message);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
