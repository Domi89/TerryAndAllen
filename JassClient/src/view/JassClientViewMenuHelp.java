package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class JassClientViewMenuHelp {
	
//https://lmgtfy.com/?q=Jass+Regeln+einfach
	
	private void helpMenu() {
		
		Stage settingsStage = new Stage();
		
		settingsStage.initModality(Modality.APPLICATION_MODAL);
		settingsStage.setTitle("Jass Regeln");
		settingsStage.setMinWidth(250);

		Button close = new Button("Ah Ok, Schliessen!");
		
		
		Label topLabel = new Label("Hier findest du die Jass-Regeln:");
		topLabel.setStyle(
				"-fx-font-size: 20px ; "
				+ "-fx-font-weight: bold;"
				+ " -fx-text-fill: white");
		
		Label linkLabel = new Label("Hier findest du die Jass-Regeln: \n"
			+	"https://lmgtfy.com/?q=Jass+Regeln+einfach"
 );
		linkLabel.setStyle(
				"-fx-font-size: 20px ; "
				+ "-fx-font-weight: bold;"
				+ " -fx-text-fill: white");
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(topLabel, linkLabel, close);
		
		Scene scene = new Scene (vBox);
		vBox.setStyle("-fx-background-image: url(/images/backgroundLogin.jpg");

		settingsStage.setScene(scene);
		settingsStage.showAndWait();
		
		close.setOnAction(e->{
			settingsStage.close();
		});

		
	}
	


	

}
