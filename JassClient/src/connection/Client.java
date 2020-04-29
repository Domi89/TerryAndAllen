package connection;

import java.io.Serializable;

//needs to implement Serializable to sende those Objects via ObjectOutputStream

public class Client implements Serializable{
	
	private String clientName;
	
	public Client (String clientName) {
		this.clientName = clientName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String toString() {
		return "Client [clientName=" + clientName + "]";
	}

}
