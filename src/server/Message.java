package server;

import java.io.Serializable;
import java.time.*;

public class Message implements Serializable{
	public String[] MessageRecipients;
	public String MessageBody;
	public LocalDateTime TimeStamp;
	
	public Message(String[] Recipients){
		MessageRecipients = Recipients;
		MessageBody = "";
				
	}
	
	
	

}
