package application;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class HashTableController implements Initializable {
	
	private LinkedList<Label>[] hash = new LinkedList[10];
	private LinkedList<Line>[] line = new LinkedList[10];
	private static int counts;
	
	@FXML
	private AnchorPane pane, pane2;
	@FXML
	private TextField inserttf, findtf, removetf;
	@FXML
	private Label indexlb, index0, index1, index2, index3, index4,
					index5, index6, index7, index8, index9;
	
	public void insert() {
		for (int i=0; i<10; i++) {
			if (hash[i] == null) {
				hash[i] = new LinkedList<Label>();
			}
			if (line[i] == null) {
				line[i] = new LinkedList<Line>();
			}
		}
		reset();
		if ((!inserttf.getText().equals("")) && (isInt(inserttf.getText()))) {
			int number = Integer.parseInt(inserttf.getText());
			if (!hasNumber(number)) {
				int index = splitInt(number);
				indexlb.setText(Integer.toString(index));
				switch (index) {
				case 0: index0.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index0.setTextFill(Color.WHITE);
					in(0, number, 10); break;
				case 1: index1.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index1.setTextFill(Color.WHITE);
					in(1, number, 69); break;
				case 2: index2.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index2.setTextFill(Color.WHITE);
					in(2, number, 128); break;
				case 3: index3.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index3.setTextFill(Color.WHITE);
					in(3, number, 187); break;
				case 4: index4.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index4.setTextFill(Color.WHITE);
					in(4, number, 246); break;
				case 5: index5.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index5.setTextFill(Color.WHITE);
					in(5, number, 305); break;
				case 6: index6.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index6.setTextFill(Color.WHITE);
					in(6, number, 364); break;
				case 7: index7.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index7.setTextFill(Color.WHITE);
					in(7, number, 423); break;
				case 8: index8.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index8.setTextFill(Color.WHITE);
					in(8, number, 482); break;
				case 9: index9.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index9.setTextFill(Color.WHITE);
					in(9, number, 541); break;
				}
			} else {
				int index = splitInt(number);
				Label label = hash[index].get(counts);
				label.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(90), Insets.EMPTY)));
				label.setTextFill(Color.WHITE);
				indexlb.setText("Exists");
				inserttf.clear();
			}
		} else {
			indexlb.setText("Invalid");
			inserttf.clear();
		}
	}
	
	private void in(int index, int number, double Y) {
		if (hash[index].size()<5) {
			Label label = new Label(inserttf.getText());
			Line lines = new Line();
			lines.setStartY(Y+24);
			lines.setEndY(Y+24);
			inserttf.clear();
			hash[index].addLast(label);
			pane2.getChildren().add(label);
			pane2.getChildren().add(lines);
			label.setFont(new Font("Tahoma", 15));
			label.setPrefSize(49, 49);
			label.setAlignment(Pos.CENTER);
			label.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(90), Insets.EMPTY)));
			label.setTextFill(Color.WHITE);
			label.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(90), new BorderWidths(2))));
			label.setLayoutY(Y);
			switch (hash[index].size()) {
			case 1: label.setLayoutX(229);
				lines.setStartX(149);
				lines.setEndX(229); break;
			case 2: label.setLayoutX(298); 
				lines.setStartX(278);
				lines.setEndX(298); break;
			case 3: label.setLayoutX(367);
				lines.setStartX(347);
				lines.setEndX(367); break;
			case 4: label.setLayoutX(436);
				lines.setStartX(416);
				lines.setEndX(436); break;
			case 5: label.setLayoutX(505);
				lines.setStartX(485);
				lines.setEndX(505); break;
			}
			lines.setStroke(Color.RED);
			line[index].add(lines);
		} else {
			indexlb.setText("Full");
			inserttf.clear();
		}
	}
	
	public void find() {
		reset();
		if ((!findtf.getText().equals("")) && (isInt(findtf.getText()))) {
			int number = Integer.parseInt(findtf.getText());
			if (hasNumber(number)) {
				int index = splitInt(number);
				indexlb.setText(Integer.toString(index));
				findtf.clear();
				switch (index) {
				case 0: index0.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index0.setTextFill(Color.WHITE); break;
				case 1: index1.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index1.setTextFill(Color.WHITE); break;
				case 2: index2.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index2.setTextFill(Color.WHITE); break;
				case 3: index3.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index3.setTextFill(Color.WHITE); break;
				case 4: index4.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index4.setTextFill(Color.WHITE); break;
				case 5: index5.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index5.setTextFill(Color.WHITE); break;
				case 6: index6.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index6.setTextFill(Color.WHITE); break;
				case 7: index7.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index7.setTextFill(Color.WHITE); break;
				case 8: index8.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index8.setTextFill(Color.WHITE); break;
				case 9: index9.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index9.setTextFill(Color.WHITE); break;
				}
				Label label = hash[index].get(counts);
				label.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(90), Insets.EMPTY)));
				label.setTextFill(Color.WHITE);
			} else {
				indexlb.setText("Doesn\'t exists");
				findtf.clear();
			}
		} else {
			indexlb.setText("Invalid");
			findtf.clear();
		}
	}
	
	public void remove() {
		reset();
		if ((!removetf.getText().equals("")) && (isInt(removetf.getText()))) {
			int number = Integer.parseInt(removetf.getText());
			if (hasNumber(number)) {
				int index = splitInt(number);
				indexlb.setText(Integer.toString(index));
				removetf.clear();
				switch (index) {
				case 0: index0.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index0.setTextFill(Color.WHITE);
					re(0, number); break;
				case 1: index1.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index1.setTextFill(Color.WHITE);
					re(1, number); break;
				case 2: index2.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index2.setTextFill(Color.WHITE);
					re(2, number); break;
				case 3: index3.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index3.setTextFill(Color.WHITE);
					re(3, number); break;
				case 4: index4.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index4.setTextFill(Color.WHITE);
					re(4, number); break;
				case 5: index5.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index5.setTextFill(Color.WHITE);
					re(5, number); break;
				case 6: index6.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index6.setTextFill(Color.WHITE);
					re(6, number); break;
				case 7: index7.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index7.setTextFill(Color.WHITE);
					re(7, number); break;
				case 8: index8.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index8.setTextFill(Color.WHITE);
					re(8, number); break;
				case 9: index9.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
					index9.setTextFill(Color.WHITE);
					re(9, number); break;
				}
			} else {
				indexlb.setText("Doesn\'t exists");
				removetf.clear();
			}
		} else {
			indexlb.setText("Invalid");
			removetf.clear();
		}
	}
	
	private void re(int index, int number) {
		int count = -1;
		for (int i=0; i<hash[index].size(); i++) {
			if (number == Integer.parseInt(hash[index].get(i).getText())) {
				count = i;
				break;
			}
		}
		Label label = hash[index].get(count);
		label.setText(null);
		label.setBorder(null);
		hash[index].remove(count);
		for (int i=count; i<hash[index].size(); i++) {
			TranslateTransition transition = new TranslateTransition();
			transition.setDuration(Duration.seconds(1));
			transition.setNode(hash[index].get(i));
			transition.setByX(-69);
			transition.play();
		}
		Line lines = line[index].getLast();
		lines.setStroke(Color.web("#FCF3CF"));
		line[index].removeLast();
	}
	
	public void back() throws IOException {
		AnchorPane child = FXMLLoader.load(getClass().getResource("Main.fxml"));
		pane.getChildren().setAll(child);
	}
	
	public void gotit() throws IOException {
		AnchorPane child = FXMLLoader.load(getClass().getResource("HashTable.fxml"));
		pane.getChildren().setAll(child);
	}
	
	private void reset() {
		index0.setBackground(new Background(new BackgroundFill(Color.web("#85C1E9"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		index0.setTextFill(Color.BLACK);
		index1.setBackground(new Background(new BackgroundFill(Color.web("#85C1E9"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		index1.setTextFill(Color.BLACK);
		index2.setBackground(new Background(new BackgroundFill(Color.web("#85C1E9"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		index2.setTextFill(Color.BLACK);
		index3.setBackground(new Background(new BackgroundFill(Color.web("#85C1E9"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		index3.setTextFill(Color.BLACK);
		index4.setBackground(new Background(new BackgroundFill(Color.web("#85C1E9"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		index4.setTextFill(Color.BLACK);
		index5.setBackground(new Background(new BackgroundFill(Color.web("#85C1E9"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		index5.setTextFill(Color.BLACK);
		index6.setBackground(new Background(new BackgroundFill(Color.web("#85C1E9"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		index6.setTextFill(Color.BLACK);
		index7.setBackground(new Background(new BackgroundFill(Color.web("#85C1E9"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		index7.setTextFill(Color.BLACK);
		index8.setBackground(new Background(new BackgroundFill(Color.web("#85C1E9"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		index8.setTextFill(Color.BLACK);
		index9.setBackground(new Background(new BackgroundFill(Color.web("#85C1E9"), CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
		index9.setTextFill(Color.BLACK);
		for (int i=0; i<10; i++) {
			if (hash[i] != null) {
				for (int j=0; j<hash[i].size(); j++) {
					Label label = hash[i].get(j);
					label.setBackground(null);
					label.setTextFill(Color.BLACK);
				}
			}
		}
	}
	
	private int splitInt(int number) {
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
	
	private boolean hasNumber(int number) {
		int index = splitInt(number);
		if (hash[index] != null) {
			for (int j = 0; j < hash[index].size(); j++) {
				if (number == Integer.parseInt(hash[index].get(j).getText())) {
					counts = j;
					return true;
				}
			}
		}
		return false;
	}
	
	static boolean isInt(String str) {
		for (int i=0; i<str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) return false;
		}
		return true;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}