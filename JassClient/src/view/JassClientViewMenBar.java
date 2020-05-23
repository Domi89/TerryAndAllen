package view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


public class JassClientViewMenBar extends MenuBar{
	
	 protected Menu datei, ansicht, hilfe;
     protected MenuItem neustart, verlassen, farbeWechseln, regeln;
     JassClientViewMenuHelp help;

     //Erstellen des Konstruktors     
     public JassClientViewMenBar() {
                    
     datei = new Menu("Datei");
     ansicht = new Menu("Ansicht");
     hilfe = new Menu("Hilfe");
     
     
     //Add the menu items
     neustart = new MenuItem("Neues Spiel starten");
     verlassen = new MenuItem("Verlassen");
     farbeWechseln = new MenuItem("Farbe Wechseln");
     regeln = new MenuItem("Regeln");
     
     //Fenster schliessen befehl
     verlassen.setOnAction((ActionEvent e) -> closeBox());
     
       
     //Zuordnen der Items
     datei.getItems().addAll(neustart, verlassen);
     ansicht.getItems().add(farbeWechseln);
     hilfe.getItems().add(regeln);
     
     this.getMenus().addAll(datei, ansicht, hilfe);
     
     }

	public void closeBox() {
          Platform.exit();
     }



}        