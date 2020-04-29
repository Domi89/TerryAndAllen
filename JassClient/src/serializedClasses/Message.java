package serializedClasses;

import java.io.Serializable;

public class Message implements Serializable{
	
	private String clientName;
	private String message;
	
	public Message(String clientName, String message) {
		this.clientName=clientName;
		this.message=message;
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
	
}
