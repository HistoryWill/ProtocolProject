package server;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class ClientThread extends Thread{
	protected Socket socket;

	    public ClientThread(Socket clientSocket) {
	        this.socket = clientSocket;
	    }
	    
	    public void run(){
	    	InputStream in;
			try {
				in = (socket.getInputStream());
				ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(in));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }

	}


