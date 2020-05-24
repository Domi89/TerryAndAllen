package view;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class JassClientViewMenuHelp {
	
		Stage settingsStage;
	
		
	public static void helpMenu() {
		
		
		Stage settingsStage = new Stage();
	
		settingsStage.initModality(Modality.APPLICATION_MODAL);
		settingsStage.setTitle("Jass Regeln");

		Button close = new Button("Ah Ok, Schliessen!");
		
		Label topLabel = new Label("Hier findest du die Jass-Regeln:");
		topLabel.setStyle(
				"-fx-font-size: 15px ; "
			+ " -fx-text-fill: White");
		
		Hyperlink link = new Hyperlink();
				link.setText("https://lmgtfy.com/?q=Jass+Regeln+einfach");
				link.setStyle("-fx-font-size: 15px;"  
						+	"-fx-text-fill: white; ");

			
		VBox vBox = new VBox();

		vBox.getChildren().addAll(topLabel, link, close);

		vBox.setStyle("-fx-min-width: 400;"
		+"-fx-min-height: 150;"
		+"-fx-max-width: 400;"
		+"-fx-max-height: 150;"
		+"-fx-background-image: url(/images/backgroundLogin.jpg)");
		Scene scene = new Scene (vBox);
	
		close.setOnAction(e -> {
			settingsStage.close();
		});
		
		
		settingsStage.setScene(scene);
		settingsStage.showAndWait();
		

		
		};

	
		
		
	}

