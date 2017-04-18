package server;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
public class ClientThread extends Thread{
	protected Socket socket;

	    public ClientThread(Socket clientSocket) {
	        this.socket = clientSocket;
	    }
	    
	    public void run(){
	    	
	    	
			try {
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    	
	    }
	    
	    public static void setup(Message x){
	    	Queue<Message> MessageQueue = new LinkedList<Message>();
	    	
	    	
	    }

	}


