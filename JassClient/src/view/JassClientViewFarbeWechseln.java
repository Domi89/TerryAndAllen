package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class JassClientViewFarbeWechseln {

	public static int colourChoice = 0;
	
	
	public static int colourChange() {
		
		Stage settingsStage = new Stage();
		
		settingsStage.initModality(Modality.APPLICATION_MODAL);
		settingsStage.setTitle("Teppich Farbe Wählen");
		settingsStage.setMinWidth(250);
		
		Label colourLabel = new Label("Wähle dein JassTeppich!");
		colourLabel.setStyle(
				"-fx-font-size: 20px ; "
				+ "-fx-font-weight: bold;"
				+ " -fx-text-fill: white");
		
			
		Button butGreen = new Button();
		butGreen.setMinSize(200.0, 100.0);
		butGreen.setMaxSize(201.0, 101.0);
		butGreen.setStyle("-fx-background-image: url(/images/JassTeppichGruen.jpg)");
		
		Button butRed = new Button();
		butRed.setMinSize(200.0, 100.0);
		butRed.setMaxSize(201.0, 101.0);
		butRed.setStyle("-fx-background-image: url(/images/JassTeppichRot.jpg)");
	
		Button butPan = new Button();
		butPan.setMinSize(200.0, 100.0);
		butPan.setMaxSize(201.0, 101.0);
		butPan.setStyle("-fx-background-image: url(/images/JassTeppichPanda.jpg)");
		
		HBox hBox = new HBox();
		hBox.getChildren().addAll(butGreen, butRed, butPan);		
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(colourLabel, hBox);
		
		Scene scene = new Scene (vBox);
		vBox.setStyle("-fx-background-color: grey");
		
	
		
		butGreen.setOnAction(e-> {
			colourChoice = 0;
					
			settingsStage.close();
		});
	
		butRed.setOnAction(e-> {
			colourChoice = 1;
			
			settingsStage.close();
		});
		
		butPan.setOnAction(e-> {
			colourChoice = 2;
		
			settingsStage.close();
		});
		
		
		settingsStage.setScene(scene);
		settingsStage.showAndWait();
		
				
		
	return colourChoice;
	
	} 
	
	
	
	
	
}
