package application;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class QueueController implements Initializable {
	
	private LinkedList<Label> queue = new LinkedList<Label>();
	
	@FXML
	private AnchorPane pane, pane1, pane2;
	@FXML
	private Button enbtn, debtn;
	@FXML
	private TextField entf;
	@FXML
	private Label delb, qty;
	
	public void enqueue() {
		if ((entf.getText() != "") && (queue.size()<11)) {
			en(queue.size()+1);
			qty.setText(Integer.toString(queue.size()));
		} else entf.clear();
	}
	
	public void en(int number) {
		if (entf.getText() != "") {
			Image image = new Image("/dairycattle.jpg");
	        ImageView imageView = new ImageView(image);
			Label label = new Label(entf.getText(), imageView);
			entf.clear();
			queue.addLast(label);
			pane2.getChildren().add(label);
			label.resize(80, 80);
			label.setFont(new Font(20));
			label.setAlignment(Pos.CENTER);
			label.setTextFill(Color.web("#000000"));
			label.setBackground(new Background(new BackgroundFill(Color.web("#F5DEB3"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
			label.setLayoutX(75);
			label.setLayoutY(-100);
			
			Polyline polyline = new Polyline();
			switch (number) {
			case 1: polyline.getPoints().addAll(new Double[] {
					0.0, 0.0,
					0.0, 500.0,
					200.0, 500.0,
					200.0, 300.0,
					400.0, 300.0,
					400.0, 500.0}); break;
			case 2: polyline.getPoints().addAll(new Double[] {
					0.0, 0.0,
					0.0, 500.0,
					200.0, 500.0,
					200.0, 300.0,
					400.0, 300.0,
					400.0, 400.0}); break;
			case 3: polyline.getPoints().addAll(new Double[] {
					0.0, 0.0,
					0.0, 500.0,
					200.0, 500.0,
					200.0, 300.0,
					400.0, 300.0}); break;
			case 4: polyline.getPoints().addAll(new Double[] {
					0.0, 0.0,
					0.0, 500.0,
					200.0, 500.0,
					200.0, 300.0,
					300.0, 300.0}); break;
			case 5: polyline.getPoints().addAll(new Double[] {
					0.0, 0.0,
					0.0, 500.0,
					200.0, 500.0,
					200.0, 300.0}); break;
			case 6: polyline.getPoints().addAll(new Double[] {
					0.0, 0.0,
					0.0, 500.0,
					200.0, 500.0,
					200.0, 400.0}); break;
			case 7: polyline.getPoints().addAll(new Double[] {
					0.0, 0.0,
					0.0, 500.0,
					200.0, 500.0}); break;
			case 8: polyline.getPoints().addAll(new Double[] {
					0.0, 0.0,
					0.0, 500.0,
					100.0, 500.0}); break;
			case 9: polyline.getPoints().addAll(new Double[] {
					0.0, 0.0,
					0.0, 500.0}); break;
			case 10: polyline.getPoints().addAll(new Double[] {
					0.0, 0.0,
					0.0, 400.0}); break;
			case 11: polyline.getPoints().addAll(new Double[] {
					0.0, 0.0,
					0.0, 300.0}); break;
			}
			
			PathTransition transition = new PathTransition();
			transition.setDuration(Duration.seconds(3));
			transition.setNode(label);
			transition.setPath(polyline);
			transition.play();
		}
	}
	
	public void dequeue() {
		if (queue.size()>0) {
			Label label = queue.getFirst();
			delb.setText(label.getText());
			queue.removeFirst();
			qty.setText(Integer.toString(queue.size()));
			TranslateTransition transition = new TranslateTransition();
			transition.setDuration(Duration.seconds(1));
			transition.setNode(label);
			transition.setToX(375);
			transition.setToY(700);
			transition.play();
			
			for (int i = 0; i < queue.size(); i++) {
			    de(i);
			}
		}
	}
	
	public void de(int number) {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(1));
		transition.setNode(queue.get(number));
		switch (number) {
		case 0:
			transition.setToX(375);
			transition.setToY(460);
			break;
		case 1:
			transition.setToX(375);
			transition.setToY(360);
			break;
		case 2:
			transition.setToX(375);
			transition.setToY(260);
			break;
		case 3:
			transition.setToX(275);
			transition.setToY(260);
			break;
		case 4:
			transition.setToX(175);
			transition.setToY(260);
			break;
		case 5:
			transition.setToX(175);
			transition.setToY(360);
			break;
		case 6:
			transition.setToX(175);
			transition.setToY(460);
			break;
		case 7:
			transition.setToX(75);
			transition.setToY(460);
			break;
		case 8:
			transition.setToX(-25);
			transition.setToY(460);
			break;
		case 9:
			transition.setToX(-25);
			transition.setToY(360);
			break;
		}
		transition.play();
	}
	
	public void back() throws IOException {
		AnchorPane child = FXMLLoader.load(getClass().getResource("Main.fxml"));
		pane.getChildren().setAll(child);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}