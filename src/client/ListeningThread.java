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
	static Queue<String> clientmessageStack = new LinkedList<String>();
	    public ListeningThread(Socket clientSocket) {
	        this.socket = clientSocket;
	    }
	    static String fromServer;
	   // static InputStreamReader input;
	    static DataInputStream input;
    	static DataOutputStream output;
    	static BufferedReader in;
	    @SuppressWarnings("deprecation")
		public void run(){
	    	
	    	
	    	 
			try {
				input =new DataInputStream(socket.getInputStream());
				output = new DataOutputStream(socket.getOutputStream());

			}catch(IOException e){
				System.out.println(e);
			}
			
			while(true){
				try {
					String meme;
					
					/*while((meme = in.readLine())!=null){
						System.out.println(meme);
						System.out.println("got to");
					}
					System.out.println("E1");
					fromServer = in.readLine();*/
					fromServer = input.readUTF();
					
				} catch (IOException e) {
					System.out.println(e);
					e.printStackTrace();
				}
				
				Main.fuckgit(fromServer);
			
				
				
				
			}
			
	    	
	    }
		public void messageNotify(String fromServer2) {
			try {
				output.writeUTF(fromServer2);
				output.flush();
			} 
			catch(IOException e){
				System.out.println(e);
			}
		}
			
			
		}
