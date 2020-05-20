package view;

import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class JassClientViewFarbeWechseln {

	public int colourChoice = 0;
	
	Button butGreen, butRed, butPanda;
	

	
	public int colourChange() {
		
		Stage settingsStage = new Stage();
		
		settingsStage.initModality(Modality.APPLICATION_MODAL);
		settingsStage.setTitle("Settings");
		settingsStage.setMinWidth(250);
		
			
		Button butGreen = new Button("Grüne JassMatte");
		butGreen.setMinSize(200.0, 100.0);
		butGreen.setMaxSize(201.0, 101.0);
		butGreen.setStyle("-fx-font-size: 20px ; -fx-font-weight: bold;"
				+ " -fx-text-fill: black; -fx-background-image: url(/images/JassTeppichGruen.jpg)");
		
		Button butRed = new Button("Rote JassMatte");
		butRed.setMinSize(200.0, 100.0);
		butRed.setMaxSize(201.0, 101.0);
		butRed.setStyle("-fx-font-size: 20px ; -fx-font-weight: bold;"
				+ " -fx-text-fill: black; -fx-background-image: url(/images/JassTeppichRot.jpg)");
	
		Button butPan = new Button("Panda JassMatte");
		butPan.setMinSize(200.0, 100.0);
		butPan.setMaxSize(201.0, 101.0);
		butPan.setStyle("-fx-font-size: 20px ; -fx-font-weight: bold;"
				+ " -fx-text-fill: black; -fx-background-image: url(/images/JassTeppichPanda.jpg)");
		
		
		
		
		
		
	return colourChoice;
	
	} 
	
	
	
	
	
	
}
