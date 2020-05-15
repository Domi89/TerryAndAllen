package view;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class JassClientConnectMenBar extends MenuBar{
               
               protected Menu Start;
               protected MenuItem verlassen;
               
               //Create Constructor for the MneBar with above items
               
               public JassClientConnectMenBar() {
                              
               Start = new Menu("Start");
                              
               //Add the menu items
               verlassen = new MenuItem("Verlassen");

               
               verlassen.setOnAction((ActionEvent e) -> closeBox());
               
               //Add the items
               Start.getItems().add(verlassen);
               
               this.getMenus().add(Start);
               }

               public void closeBox() {
                              Platform.exit();
               }
                              
               

}
