package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable{
	
	public int arraySize;
	ArrayList<String> newlist = new ArrayList<String>();

	
	public int getArraySize() {
		return arraySize;
	}
	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}
	@FXML
	private ComboBox<String> combobox;
	ObservableList<String> list = FXCollections.observableArrayList("5", "6", "7","8","9","10");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		combobox.setItems(list);
		
	}
	@FXML
	private AnchorPane rootPane;

	@FXML
	public void hashtable() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("HashTable.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	@FXML
	public void arraylist() throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("ArrayList.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	@FXML
	private void queue(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Queue.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	@FXML
	public void exit() {
		System.exit(0);
	}
	
	public void comboChanged(ActionEvent event) {
		arraySize = Integer.parseInt(combobox.getValue());
		System.out.println(arraySize);
	}
	
	@FXML
	private TextField textField;
	@FXML 
	private Button btnReady;
	
	@FXML
	public void getText(ActionEvent event) {
		String word = textField.getText();
		System.out.println(word);
		String[] num = word.split(",");
		for (int i=0; i<arraySize; i++) {
			newlist.add(num[i]);
		}
		System.out.println();
        for (String obj : newlist) {
            System.out.print(obj + ", ");
        }
        
        btnReady.setStyle("-fx-background-color: #DD5656");
	}
	public ArrayList<String> getNewlist() {
		return newlist;
	}
	public void setNewlist(ArrayList<String> newlist) {
		this.newlist = newlist;
	}

}
