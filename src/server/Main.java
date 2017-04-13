package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Stack;

public class Main {
	final static int  portnumber = 8080;
	static ServerSocket serverSocket = null;
    static Socket socket = null;
    static Stack<Message> messageStack = new Stack();
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
    
}
