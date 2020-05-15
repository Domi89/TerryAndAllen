package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.JassClientModel;

public class JassClientConnectCenter extends GridPane{
               
               public JassClientConnectCenter(Stage stage, JassClientModel model) {

                              //Create the fields for the Connection 
                              Label benutzer = new Label("Username: ");
                              Label iP = new Label ("IP: ");
                              Label port = new Label("Port: ");
               
                              TextField benutzerText = new TextField();
                              TextField ipText = new TextField();
                              TextField portText = new TextField();
                              //Connection BUtton
                              Button connect = new Button ("Verbinden");
                                            
                              //Adding IP label and field
                              this.add(benutzer, 1,1);
                              this.add(iP,2,1);
                              this.add(ipText,3,1);
                              //adding port label and field
                              this.add(benutzerText,1,2);
                              this.add(port,2,2);
                              this.add(portText,3,2);
                              
                              //adding connection button
                              this.add(connect,3,3);

               
               }
}
