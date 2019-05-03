package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {
	
	@FXML
	private AnchorPane pane1, pane2;
	
	public void queue() throws IOException {
		AnchorPane child1 = FXMLLoader.load(getClass().getResource("Queue1.fxml"));
		pane1.getChildren().setAll(child1);
		AnchorPane child2 = FXMLLoader.load(getClass().getResource("Test.fxml"));
		pane2.getChildren().setAll(child2);
	}
	
	public void hashtable() {
		
	}
	
	public void arraylist() {
		
	}
	
	public void exit() {
		System.exit(0);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}