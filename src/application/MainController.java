package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
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
		AnchorPane child = FXMLLoader.load(getClass().getResource("HashFunction.fxml"));
		pane.getChildren().setAll(child);
	}
	
	public void arraylist() throws IOException {
		AnchorPane child = FXMLLoader.load(getClass().getResource("ArrayList.fxml"));
		pane.getChildren().setAll(child);
	}
	
	public void exit() {
		System.exit(0);
	}
	
	@FXML
	protected void goFacebook1() {
		goLink("https://facebook.com/nguyenvietngoc.quang");
	}
	
	@FXML
	protected void goGitHub1() {
		goLink("https://github.com/nguyenvietngocquang");
	}
	
	@FXML
	protected void goFacebook2() {
		goLink("https://www.facebook.com/thehung.phung.712");
	}
	
	@FXML
	protected void goGitHub2() {
		goLink("https://github.com/Ti-amo");
	}
	
	static void goLink(String link) {
		try {
			Desktop.getDesktop().browse(new URI(link));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}