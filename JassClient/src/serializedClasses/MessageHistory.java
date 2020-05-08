package serializedClasses;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class MessageHistory implements Serializable{
	
	private Stack<Message> history;
	
	public MessageHistory() {
		this.history = new Stack<Message>();
	}
	
	public void addMessage(Message message) {
		this.history.push(message);
	}
	
	public Message getLatestMessage() {
		return history.peek();
	}
	
	public Stack getMessageHistory() {
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
