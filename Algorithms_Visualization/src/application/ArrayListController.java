package application;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

import application.MainController;
import javafx.animation.TranslateTransition;
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
import javafx.util.Duration;

public class ArrayListController extends Application{

	String value = null;
	public String getNum() {
		return value;
	}

	public void setNum(String value) {
		this.value = value;
	}

	//LinkedList<StackPane> listPane = new LinkedList<StackPane>();
	ArrayList<StackPane> listPane = new ArrayList<StackPane>();
	@FXML
	private TextField statusText;
	@FXML
	private TextField valueAddField;
	@FXML 
	public Button btnAddItem;
	@FXML
	public void addItem(ActionEvent event) {
		btnAddItem.setStyle("-fx-background-color: #DD5656");
		btnInsertItem.setStyle("-fx-background-color: #60d92e");
		btnDeleteItem.setStyle("-fx-background-color: #60d92e");
		value = valueAddField.getText();
		StackPane obj = createShape(value);
		listPane.add(obj);
		setListPane(listPane);
		arrayListPane.getChildren().add(obj);
		int y = listPane.size()-1;
		getWay(obj, y);
		valueAddField.clear();
		statusText.setText("Done!");
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
		value = valueInsertField.getText();
		int index = Integer.parseInt(indexInsertField.getText());
		if (index > listPane.size()) statusText.setText("Wrong index!");
		else {
			StackPane obj = createShape(value);
			if (index == 0) {
				for (int i=0; i<listPane.size(); i++) {
					goDown(listPane.get(i), i);	
				}
			}
			else if (index > 0) {
				for (int i=index; i<listPane.size(); i++) {
					goDown(listPane.get(i), i-index+1);
				}
			}
			arrayListPane.getChildren().add(obj);
			getWay(obj, index);
			listPane.add(index, obj);
			statusText.setText(""+listPane.size());
		}
		StackPane obj = createShape(value);
		listPane.add(index, obj);
		setListPane(listPane);
		arrayListPane.getChildren().add(obj);
		if (index == 0) {
			for (int i=0; i<listPane.size(); i++) {
				goDown(listPane.get(i), i-1);	
			}
		}
		else if (index == (listPane.size()-1)) goDown(listPane.get(index+1), 1);
		else {
			for (int i=index; i<listPane.size(); i++) {
				goDown(listPane.get(i), i-index);
			}
		}
		getWay(obj, index);
		valueInsertField.clear();
		indexInsertField.clear();
	}
	
	@FXML
	private TextField indexDeleteField;
	@FXML 
	public Button btnDeleteItem;
	@FXML
	public void deleteItem(ActionEvent event) {
		btnAddItem.setStyle("-fx-background-color: #60d92e");
		btnInsertItem.setStyle("-fx-background-color: #60d92e");
		btnDeleteItem.setStyle("-fx-background-color: #DD5656");
		int index = Integer.parseInt(indexDeleteField.getText());
		if (index > listPane.size()) statusText.setText("Wrong index!");
		else {
			statusText.setText("Done!");
			if (index == 0) {
				for (int i=index+1; i<listPane.size(); i++) {
					goUp(listPane.get(i), i-1);	
				}
			}
			else if (index > 0){
				for (int i=index; i<listPane.size(); i++) {
					goUp(listPane.get(i), i-index);
				}
			}
			arrayListPane.getChildren().remove(listPane.get(index));
			listPane.remove(index);
			//setListPane(listPane);
		}
		indexDeleteField.clear();
	}
	public ArrayList<StackPane> getListPane() {
		return listPane;
	}
	public void setListPane(ArrayList<StackPane> listPane) {
		this.listPane = listPane;
	}

	@FXML
	private AnchorPane arrayListPane;
	@FXML
	public void back(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Main.fxml"));
		arrayListPane.getChildren().setAll(pane);
	}

	public StackPane createShape(String num) {
			Rectangle obj = new Rectangle();
			obj.setFill(Color.GREENYELLOW);
			obj.setHeight(90);
			obj.setWidth(80);
			Text text = new Text();
			text.setText(num);
			StackPane stack = new StackPane();
			stack.getChildren().addAll(obj, text);
			stack.setLayoutX(400);
			stack.setLayoutY(60);
			return stack;
	}
	
	public void getWay(StackPane stack, int y) {
		TranslateTransition way =  new TranslateTransition();
		way.setDuration(Duration.seconds(2));
		way.setToX(400);
		way.setToY(-30 + y*95);
		way.setNode(stack);
		way.play();
		System.out.println("Done");
	}
	
	public void goDown(StackPane stack, int y) {
		TranslateTransition way = new TranslateTransition();
		way.setDuration(Duration.seconds(0.5));
		way.setToY(65+y*95);
		way.setNode(stack);
		way.play();
	}
	
	public void goUp(StackPane stack, int y) {
		TranslateTransition way = new TranslateTransition();
		way.setDuration(Duration.seconds(1));
		way.setToY(y*95-30);
		way.setNode(stack);
		way.play();
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("ArrayList.fxml"));
			Scene scene = new Scene(root,1000,600);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			System.out.println("Error!");
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
