package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {
	protected ServerSocket serverSocket;
	static Socket socket = null;
	
	public ServerThread(ServerSocket x){
		this.serverSocket = x;
	}
	
	public void run(){
	while (true) {
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        }
        // new thread for a client
        new ClientThread(socket).start();
    }
	}
}
