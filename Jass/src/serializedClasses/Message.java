package serializedClasses;

import java.io.Serializable;

public class Message implements Serializable{
	
	private String clientName;
	private String message;
	private boolean sent;
	
	public Message(String clientName, String message) {
		this.clientName=clientName;
		this.message=message;
		this.sent=false;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString() {
		String s = "";
		s+= this.clientName;
		s+= ": ";
		s+= this.message;
		return s;
	}
	
	public void setSent(boolean b) {
		this.sent = b;
	}
	
	public boolean getSent() {
		return this.sent;
	}
	
}
