package serializedClasses;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.net.Socket;

public class Client implements Serializable {

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
		return "Client [clientName=" + clientName + "] ";
	}

}
