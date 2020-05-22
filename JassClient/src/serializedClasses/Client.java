package serializedClasses;

import java.io.Serializable;

public class Client implements Serializable{
	
	private volatile String clientName;
	private int postition;
	private int pointsSmall, pointsBig;
	
	public int getPointsBig() {
		return pointsBig;
	}

	public void setPointsBig(int pointsBig) {
		this.pointsBig = pointsBig;
	}

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

	public int getPointsSmall() {
		return pointsSmall;
	}

	public void setPointsSmall(int pointsSmall) {
		this.pointsSmall = pointsSmall;
	}

}
