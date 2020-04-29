package serializedClasses;

public class Message {
	
	private String clientName;
	private String message;
	
	public Message() {
		this.clientName = Client.getClientName();
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
