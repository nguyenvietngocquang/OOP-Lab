package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SampleController implements Initializable{
	@FXML
	
	private Button queueBtn, arrayListBtn, hashTableBtn;
	private Label lb;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String mess = "";
		queueBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Done!");
				
			}
		});
	}
	
	public void menuBtn (ActionEvent event) {
		String mess = "";
		queueBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Done!");
				
			}
		});
		if (arrayListBtn.isPressed()) {
			mess += arrayListBtn.getText() + "\n";
		}
		if (hashTableBtn.isPressed()) {
			mess += hashTableBtn.getText() + "\n";
		}
		lb.setText(mess);
	}
}
