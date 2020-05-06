package ServerConnection;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import serializedClasses.Message;

public class MessageHistory {
	
	Stack<Message> history;
	
	public MessageHistory() {
		this.history = new Stack<Message>();
	}
	
	public void addMessage(Message message) {
		this.history.add(message);
	}
	
	public Message getLatestMessage() {
		return history.peek();
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
