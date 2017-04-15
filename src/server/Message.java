package server;

import java.io.Serializable;
import java.time.*;
/*
 * A serializable object class that will allow messages to be sent to and 
 * from the Server
 */
public class Message implements Serializable{
	public String[] MessageRecipients;
	public String MessageBody;
	public LocalDateTime TimeStamp;
	
	/*
	 * Message constructor
	 * -Francis
	 */
	public Message(String[] Recipients){
		MessageRecipients = Recipients;
		MessageBody = "";
				
	}
	/*
	 * Changes the body of the message to the given string
	 * -Francis
	 */
	public void WriteBody(String Body){
		MessageBody = Body;
		
	}
	/*
	 * Updates the recipient list
	 * -Francis
	 */
	public void ChangeRecipients(String[]NewRecipients){
		MessageRecipients = NewRecipients;
	}
	/*
	 * Sets the time stamp on the message
	 * -Francis
	 */
	public void UpdateTimeStamp(){
		TimeStamp = LocalDateTime.now();
	}
	
	
	

}
