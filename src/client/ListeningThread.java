package client;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
public class ListeningThread extends Thread{
	protected Socket socket;
	    public ListeningThread(Socket clientSocket) {
	        this.socket = clientSocket;
	    }
	    static String fromServer;
	  
	    static DataInputStream input;
    	static DataOutputStream output;
    	static BufferedReader in;
	    @SuppressWarnings("deprecation")
		public void run(){
	    	 
			try {
				input =new DataInputStream(socket.getInputStream());
				output = new DataOutputStream(socket.getOutputStream());

			}catch(IOException DataStreamFailure){
				System.out.println(DataStreamFailure);
			}
			
			while(true){
				try {
					String meme;
					
					
					fromServer = input.readUTF();
					//System.out.println("FIXED" + fromServer);
				} catch (IOException e) {
					System.out.println(e);
					e.printStackTrace();
				}
				
				Main.MessageStater(fromServer);
			
			}
			
	    	
	    }
		public void messageNotify(String fromServer2, String name) {
			try {
				output.writeUTF(name+ ":"+fromServer2);
				output.flush();
			} 
			catch(IOException e){
				System.out.println(e);
			}
		}
			
			
		}
