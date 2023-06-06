package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		VBox vbox = new VBox();
		vbox.getChildren().add(new Calculator());
		Scene scene = new Scene(vbox, 270, 270);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Calculadora");
		primaryStage.show();
	}
}