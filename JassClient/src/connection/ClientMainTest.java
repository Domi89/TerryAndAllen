package connection;

public class ClientMainTest {

	public static void main(String args[]) throws InterruptedException {
		ClientConnection cc = new ClientConnection();
		cc.sendMessage("Homo", "Test");
		
		
	}

}
