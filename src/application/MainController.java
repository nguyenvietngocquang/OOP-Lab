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
	private AnchorPane pane;
	
	public void queue() throws IOException {
		AnchorPane child = FXMLLoader.load(getClass().getResource("Queue.fxml"));
		pane.getChildren().setAll(child);
	}
	
	public void hashtable() throws IOException {
		AnchorPane child = FXMLLoader.load(getClass().getResource("HashTable.fxml"));
		pane.getChildren().setAll(child);
	}
	
	public void arraylist() throws IOException {
		AnchorPane child = FXMLLoader.load(getClass().getResource("ArrayList.fxml"));
		pane.getChildren().setAll(child);
	}
	
	public void exit() {
		System.exit(0);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}