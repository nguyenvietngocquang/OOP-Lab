package application;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

import application.MainController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ArrayListController extends Application implements Initializable {

	String num = null;
	StackPane newPane = new StackPane();
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	MainController a = new MainController();
	ArrayList<String> newlist = new ArrayList<String>();
	ArrayList<StackPane> newPaneList = new ArrayList<StackPane>();
//	ArrayList<Text> newText = new ArrayList<Text>();
//	public void getData() {
//		for(int i=0; i<a.newlist.size(); i++) {
//			newlist.add(a.newlist.get(i));
//		}
//		System.out.println(newlist);
//	}
	
	
	@FXML
	private TextField valueAddField;
	@FXML 
	public Button btnAddItem;
	@FXML
	public void addItem(ActionEvent event) {
		btnAddItem.setStyle("-fx-background-color: #DD5656");
		btnInsertItem.setStyle("-fx-background-color: #60d92e");
		btnDeleteItem.setStyle("-fx-background-color: #60d92e");
		num = valueAddField.getText();
		//System.out.println(num);
		newlist.add(valueAddField.getText());
//		for (int i=0; i<newlist.size(); i++)
//			System.out.print(newlist.get(i)+",");
		//System.out.println();
		valueAddField.clear();
	}
	
	@FXML
	private TextField valueInsertField;
	@FXML 
	private TextField indexInsertField; 
	@FXML 
	public Button btnInsertItem;
	@FXML
	public void insertItem(ActionEvent event) {
		btnAddItem.setStyle("-fx-background-color: #60d92e");
		btnInsertItem.setStyle("-fx-background-color: #DD5656");
		btnDeleteItem.setStyle("-fx-background-color: #60d92e");
		newlist.add(Integer.parseInt(indexInsertField.getText()) , valueInsertField.getText());
		for (int i=0; i<newlist.size(); i++)
			System.out.print(newlist.get(i)+",");
		System.out.println();
		valueInsertField.clear();
		indexInsertField.clear();
	}
	
	@FXML
	private TextField valueDeleteField;
	@FXML 
	public Button btnDeleteItem;
	@FXML
	public void deleteItem(ActionEvent event) {
		btnAddItem.setStyle("-fx-background-color: #60d92e");
		btnInsertItem.setStyle("-fx-background-color: #60d92e");
		btnDeleteItem.setStyle("-fx-background-color: #DD5656");
		newlist.remove(Integer.parseInt(valueDeleteField.getText()));
		for (int i=0; i<newlist.size(); i++)
			System.out.print(newlist.get(i)+",");
		System.out.println();
		valueDeleteField.clear();
	}
	@FXML
	private AnchorPane arrayListPane;
	@FXML
	public void back(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Main.fxml"));
		arrayListPane.getChildren().setAll(pane);
	}

	public StackPane createShape(String num) {
		//getData();
		if (num != null) {
			Rectangle obj = new Rectangle();
			obj.setFill(Color.GREENYELLOW);
			obj.setHeight(87);
			obj.setWidth(81);
//			String tet = newlist.get(newlist.size()-1);
//			System.out.println(tet);
			Text text = new Text();
			text.setText(num);
			System.out.println(num);
			StackPane stack = new StackPane();
			stack.getChildren().addAll(obj, text);
			stack.setLayoutX(396);
			stack.setLayoutY(59);
			return stack;
		}
		return null;
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("ArrayList.fxml"));
			Scene scene = new Scene(root,1100,800);
			root.getChildren().add(newPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			System.out.println("Error!");
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		newPane = createShape(num);
		
	}
}
