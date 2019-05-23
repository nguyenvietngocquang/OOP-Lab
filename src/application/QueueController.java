package application;

import java.io.IOException;
import java.util.LinkedList;

import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContentDisplay;
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

public class QueueController {
	
	private LinkedList<Label> queue = new LinkedList<Label>();
	
	@FXML
	private AnchorPane pane, pane2;
	@FXML
	private TextField entf;
	@FXML
	private Label delb, qty;
	
	public void enqueue() {
		if ((!entf.getText().equals("")) && (isInt(entf.getText())) && (queue.size()<11)) {
			en(queue.size()+1);
			qty.setText(Integer.toString(queue.size()));
		} else entf.clear();
	}
	
	public void en(int number) {
		Image image = new Image("/dairycattle.jpg");
        ImageView imageView = new ImageView(image);
		Label label = new Label(entf.getText(), imageView);
		entf.clear();
		queue.addLast(label);
		pane2.getChildren().add(label);
		label.setFont(new Font("Tahoma", 20));
		label.setContentDisplay(ContentDisplay.TOP);
		label.setGraphicTextGap(0);
		label.setBackground(new Background(new BackgroundFill(Color.web("#F1C40F"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		label.setLayoutX(105);
		label.setLayoutY(-100);
		
		PathTransition transition = new PathTransition();
		Polyline polyline = new Polyline();
		switch (number) {
		case 1: polyline.getPoints().addAll(new Double[] {
				0.0, 0.0,
				0.0, 500.0,
				200.0, 500.0,
				200.0, 300.0,
				400.0, 300.0,
				400.0, 500.0});
		transition.setDuration(Duration.seconds(3)); break;
		case 2: polyline.getPoints().addAll(new Double[] {
				0.0, 0.0,
				0.0, 500.0,
				200.0, 500.0,
				200.0, 300.0,
				400.0, 300.0,
				400.0, 400.0});
		transition.setDuration(Duration.seconds(2.8)); break;
		case 3: polyline.getPoints().addAll(new Double[] {
				0.0, 0.0,
				0.0, 500.0,
				200.0, 500.0,
				200.0, 300.0,
				400.0, 300.0});
		transition.setDuration(Duration.seconds(2.6)); break;
		case 4: polyline.getPoints().addAll(new Double[] {
				0.0, 0.0,
				0.0, 500.0,
				200.0, 500.0,
				200.0, 300.0,
				300.0, 300.0});
		transition.setDuration(Duration.seconds(2.4)); break;
		case 5: polyline.getPoints().addAll(new Double[] {
				0.0, 0.0,
				0.0, 500.0,
				200.0, 500.0,
				200.0, 300.0});
		transition.setDuration(Duration.seconds(2.2)); break;
		case 6: polyline.getPoints().addAll(new Double[] {
				0.0, 0.0,
				0.0, 500.0,
				200.0, 500.0,
				200.0, 400.0});
		transition.setDuration(Duration.seconds(2)); break;
		case 7: polyline.getPoints().addAll(new Double[] {
				0.0, 0.0,
				0.0, 500.0,
				200.0, 500.0});
		transition.setDuration(Duration.seconds(1.8)); break;
		case 8: polyline.getPoints().addAll(new Double[] {
				0.0, 0.0,
				0.0, 500.0,
				100.0, 500.0});
		transition.setDuration(Duration.seconds(1.6)); break;
		case 9: polyline.getPoints().addAll(new Double[] {
				0.0, 0.0,
				0.0, 500.0});
		transition.setDuration(Duration.seconds(1.4)); break;
		case 10: polyline.getPoints().addAll(new Double[] {
				0.0, 0.0,
				0.0, 400.0});
		transition.setDuration(Duration.seconds(1.2)); break;
		case 11: polyline.getPoints().addAll(new Double[] {
				0.0, 0.0,
				0.0, 300.0});
		transition.setDuration(Duration.seconds(1)); break;
		}
		
		transition.setNode(label);
		transition.setPath(polyline);
		transition.play();
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
			transition.setToX(360);
			transition.setToY(750);
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
		case 0: transition.setToX(360);
			transition.setToY(460); break;
		case 1: transition.setToX(360);
			transition.setToY(360); break;
		case 2: transition.setToX(360);
			transition.setToY(260); break;
		case 3: transition.setToX(260);
			transition.setToY(260); break;
		case 4: transition.setToX(160);
			transition.setToY(260); break;
		case 5: transition.setToX(160);
			transition.setToY(360); break;
		case 6: transition.setToX(160);
			transition.setToY(460); break;
		case 7: transition.setToX(60);
			transition.setToY(460); break;
		case 8: transition.setToX(-40);
			transition.setToY(460); break;
		case 9: transition.setToX(-40);
			transition.setToY(360); break;
		}
		transition.play();
	}
	
	public void back() throws IOException {
		AnchorPane child = FXMLLoader.load(getClass().getResource("Main.fxml"));
		pane.getChildren().setAll(child);
	}
	
	static boolean isInt(String str) {
		for (int i=0; i<str.length(); i++) {
			if ((i==0) && (str.charAt(i) == '-')) continue;
			if (!Character.isDigit(str.charAt(i))) return false;
		}
		return true;
	}
}