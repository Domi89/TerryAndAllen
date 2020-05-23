package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class JassClientViewMenuHelp {
	
		
	public static void helpMenu() {
		
		
		Stage settingsStage = new Stage();
	
		settingsStage.initModality(Modality.APPLICATION_MODAL);
		settingsStage.setTitle("Jass Regeln");
		settingsStage.setMinWidth(250);

		
		Button close = new Button("Ah Ok, Schliessen!");
		
		
		Label topLabel = new Label("Hier findest du die Jass-Regeln:");
		topLabel.setStyle(
				"-fx-font-size: 15px ; "
				+ "-fx-font-weight: bold;"
				+"-fx-background-color: lightgrey;"		
				+ " -fx-text-fill: Black");
		
		Label linkLabel = new Label("https://lmgtfy.com/?q=Jass+Regeln+einfach" );
		linkLabel.setStyle(
				"-fx-font-size: 15px; "
				+"-fx-background-color: lightgrey;"
				+ " -fx-text-fill: black");
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(topLabel, linkLabel, close);
		vBox.setStyle("-fx-min-width: 400;"
		+"-fx-min-height: 200;"
		+"-fx-max-width: 400;"
		+"-fx-max-height: 200;"
		+"-fx-background-image: url(/images/backgroundLogin.jpg)");
		Scene scene = new Scene (vBox);
	
		settingsStage.setScene(scene);
		settingsStage.showAndWait();
		
		close.setOnAction(e->{
			settingsStage.close();
		});

		
	}
	

}
