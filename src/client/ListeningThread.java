package client;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
/*
 * @author Will
 * @author Francis
 */

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
