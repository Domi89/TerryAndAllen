package serializedClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class MessageHistory implements Serializable{
	
	private ArrayList<Message> history;
	
	public MessageHistory() {
		this.history = new ArrayList<Message>();
	}
	
	public void addMessage(Message message) {
		this.history.add(message);
	}
	
	public Message getLatestMessage() {
		return history.get(history.size()-1);
	}
	
	public ArrayList<Message> getMessageHistory() {
		return history;
	}
	
	public String toString() {
		Iterator iti = this.history.iterator();
		String s ="";
		while(iti.hasNext()) {
			s+=iti.next();
			s+="\n";			
		}
	return s;
	}

}