package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientThread{
	protected Socket socket;
	DataInputStream input;
	Queue<String> messages = new PriorityQueue<String>();
	
	public ClientThread(Socket s) {
		this.socket = s;
	}
	
	public void input() throws Exception {
			//establish connection
			try {
				input = new DataInputStream(this.socket.getInputStream());
			} catch (IOException e) {
				System.err.println(e);
			}
			
			//communicate with client
			try {
				String in = input.readUTF();
				if (!in.equals(null)) {
					this.messages.add(in);
				}
			} catch (IOException e) {
				System.err.println(e);
			}
	}
	
	public String output() {
		if (!this.messages.isEmpty()) {
			return this.messages.remove();
		} else {
			return null;
		}
	}
}