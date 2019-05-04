package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class QueueController implements Initializable {
	
	@FXML
	private AnchorPane pane;
	
	public void back() throws IOException {
		AnchorPane child = FXMLLoader.load(getClass().getResource("Main.fxml"));
		pane.getChildren().setAll(child);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}