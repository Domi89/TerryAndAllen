package controller;

import application.JassClientApplication;
import model.JassClientModel;
import view.JassClientConnectCenter;


public class ConnectCenterController {
	
	private JassClientModel model;
	private JassClientConnectCenter view;
	private JassClientApplication start = new JassClientApplication();
	
	// Supplier ()->
	
	private Boolean benutzerNameValidate = false;
	private Boolean ipValidate = false;
	private Boolean portValidate = false;

	
	public ConnectCenterController(JassClientModel model, JassClientConnectCenter view) {
		this.model = model;
		this.view = view;
		
		
		this.view.getBenutzerText().textProperty().addListener(
				(observable, oldValue, newValue) -> validateBenutzerName(newValue)
				);
		
		this.view.getIpText().textProperty().addListener(
				(observable, oldValue, newValue) -> validateIpText(newValue)
				);
		
		this.view.getPortText().textProperty().addListener(
				(observable, oldValue, newValue) -> validatePortText(newValue)
				);
		
		this.view.getConnect().setOnAction(e -> connectToServer());
		
		
		
	
	}

	private Object validatePortText(String newValue) {
		
		try {
			int port = Integer.parseInt(newValue);
			if(port<1 || port>65535) {
				this.portValidate = false;
				this.view.getPortText().setId("invalid");
			} else {
				this.portValidate = true;
				this.view.getPortText().setId("normal");
				System.out.println("Test "+this.portValidate);
			}	
		} catch (NumberFormatException e) {
			System.out.println("Port: Keine Zahl eingegeben");
			this.portValidate = false;
			this.view.getPortText().setId("invalid");
		}
		
		buttonValidate();
		
		
		return null;
	}

	private Object validateIpText(String newValue) {
		if(newValue.equals("localhost")) {
			this.ipValidate = true;
			this.view.getIpText().setId("normal");
		} else {
			if(validateIP(newValue)) {
				this.ipValidate = true;
				this.view.getIpText().setId("normal");
			} else {
				this.view.getIpText().setId("invalid");
				this.ipValidate = false;
			}
		}
		
		buttonValidate();
		
		return null;
	}
	
	// method took from https://stackoverflow.com/Questions/5667371/validate-ipv4-address-in-java
	public static boolean validateIP(final String ip) {
	    String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
	    return ip.matches(PATTERN);
	}
	
	private void buttonValidate() {
		
		if(this.benutzerNameValidate&&this.ipValidate&&this.portValidate) {
			this.view.getConnect().setDisable(false);
		} else {
			this.view.getConnect().setDisable(true);
		}
	}


	private Object validateBenutzerName(String newValue) {
		if(newValue.equals("")) {
			this.benutzerNameValidate = false;
			this.view.getBenutzerText().setId("invalid");
		} else {
			this.benutzerNameValidate = true;
			this.view.getBenutzerText().setId("normal");
		}
		
		buttonValidate();
		
		return null;
	}

	private void connectToServer() {
		//ServerThread im Model öffnen
		
		int port = Integer.parseInt(this.view.getPortText().getText());
		this.model.connectToServer(this.view.getBenutzerText().getText(), this.view.getIpText().getText(), port);
		
		
		ConnectedController cc = new ConnectedController(this.view);
		cc.run();
	}
	
	

	
	

}
