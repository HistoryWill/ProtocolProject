package server;

<<<<<<< HEAD
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Queue;

=======

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	final static int  portnumber = 8080;
	static ServerSocket serverSocket = null;
    static Socket socket = null;
    static Queue<Message> messageStack = new LinkedList(); //This will act as the central message Depositroy
    
    public static void main(String args[]){
    	
    	setup();
    	
    }
    
    public static void setup(){
    	try {
            serverSocket = new ServerSocket(portnumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    	new ServerThread(serverSocket).start();
    }
    
    public static void severLoop(){
    	
    }
<<<<<<< HEAD
    
=======
>>>>>>> refs/remotes/origin/master
public class Main {
	public static final int port = 8080;
	
	public HashSet<String> user;
	public Queue<String> messages;
	
    public static void main(String[] args) throws Exception {
        System.out.println("WE'RE IN BOYS");
        ServerSocket serverSocket = new ServerSocket(port);
        
        
    }
<<<<<<< HEAD
    
=======
>>>>>>> refs/remotes/origin/master
>>>>>>> refs/remotes/origin/master
=======
>>>>>>> master
}
