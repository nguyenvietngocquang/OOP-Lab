package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class HashTableController implements Initializable {
	
	@FXML
	private AnchorPane pane;
	@FXML
	private TextField inserttf, findtf;
	
	public void insert() {
		
	}
	
	public void find() {
		
	}
	
	public void back() throws IOException {
		AnchorPane child = FXMLLoader.load(getClass().getResource("Main.fxml"));
		pane.getChildren().setAll(child);
	}
	
	public int splitInt(int number) {
		int count=0, sum=0, n=0, index;
		int temp = number;
		while (temp>=1) {
	        temp/=10;
	        count++;
	    }
		Integer[] digit = new Integer[count];
		while (number>=1) {
			int mod = number%10;
			digit[n] = mod;
			number/=10;
			n++;
		}
		for (int i=0; i<count; i++) {
			sum+=digit[i];
		}
		index = sum%10;
		return index;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}