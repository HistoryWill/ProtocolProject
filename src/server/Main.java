package server;

import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Queue;

public class Main {
	public static final int port = 8080;
	
	public HashSet<String> users;
	public Queue<String> messages;
	
    public static void main(String[] args) throws Exception {
        System.out.println("WE'RE IN BOYS");
        ServerSocket serverSocket = new ServerSocket(port);
        
        
    }
    
}
