package serializedClasses;

import java.io.Serializable;

public class Client implements Serializable{
	
	private volatile String clientName;
	private int postition;
	
	public Client (String clientName) {
		this.clientName = clientName;
	}

	public synchronized String getClientName() {
		return clientName;
	}

	public synchronized void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public synchronized String toString() {
		return "Client [clientName=" + clientName + "]";
	}

	public int getPostition() {
		return postition;
	}

	public void setPostition(int postition) {
		this.postition = postition;
	}
	
	

}
