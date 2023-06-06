package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Calculator extends VBox implements EventHandler<ActionEvent> {

	private Text displayText;
	private String operand1;
	private String operand2;
	private String operator;

	public Calculator() {
		super(10);
		this.displayText = new Text();
		this.operand1 = "";
		this.operand2 = "";
		this.operator = "";

		Rectangle rectangle = new Rectangle(250, 50);
		rectangle.setStyle("-fx-fill: white; -fx-stroke: gray;");

		StackPane stackPane = new StackPane(rectangle, displayText);
		stackPane.setPadding(new Insets(10));

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setVgap(5);
		gridPane.setHgap(5);
		gridPane.setAlignment(Pos.CENTER);

		Button button7 = new Button("7");
		button7.setPrefWidth(50);
		button7.setOnAction(this);
		gridPane.add(button7, 0, 0);

		Button button8 = new Button("8");
		button8.setPrefWidth(50);
		button8.setOnAction(this);
		gridPane.add(button8, 1, 0);

		Button button9 = new Button("9");
		button9.setPrefWidth(50);
		button9.setOnAction(this);
		gridPane.add(button9, 2, 0);

		Button buttonDiv = new Button("/");
		buttonDiv.setPrefWidth(50);
		buttonDiv.setOnAction(this);
		gridPane.add(buttonDiv, 3, 0);

		Button button4 = new Button("4");
		button4.setPrefWidth(50);
		button4.setOnAction(this);
		gridPane.add(button4, 0, 1);

		Button button5 = new Button("5");
		button5.setPrefWidth(50);
		button5.setOnAction(this);
		gridPane.add(button5, 1, 1);

		Button button6 = new Button("6");
		button6.setPrefWidth(50);
		button6.setOnAction(this);
		gridPane.add(button6, 2, 1);

		Button buttonMul = new Button("*");
		buttonMul.setPrefWidth(50);
		buttonMul.setOnAction(this);
		gridPane.add(buttonMul, 3, 1);

		Button button1 = new Button("1");
		button1.setPrefWidth(50);
		button1.setOnAction(this);
		gridPane.add(button1, 0, 2);

		Button button2 = new Button("2");
		button2.setPrefWidth(50);
		button2.setOnAction(this);
		gridPane.add(button2, 1, 2);

		Button button3 = new Button("3");
		button3.setPrefWidth(50);
		button3.setOnAction(this);
		gridPane.add(button3, 2, 2);

		Button buttonSub = new Button("-");
		buttonSub.setPrefWidth(50);
		buttonSub.setOnAction(this);
		gridPane.add(buttonSub, 3, 2);

		Button button0 = new Button("0");
		button0.setPrefWidth(105);
		button0.setOnAction(this);
		gridPane.add(button0, 0, 3, 2, 1);

		Button buttonAdd = new Button("+");
		buttonAdd.setPrefWidth(50);
		buttonAdd.setOnAction(this);
		gridPane.add(buttonAdd, 2, 3);

		Button buttonEquals = new Button("=");
		buttonEquals.setPrefWidth(50);
		buttonEquals.setOnAction(this);
		gridPane.add(buttonEquals, 3, 3);

		Button buttonClear = new Button("C");
		buttonClear.setPrefWidth(215);
		buttonClear.setOnAction(this);
		gridPane.add(buttonClear, 0, 4, 4, 1);

		this.getChildren().addAll(stackPane, gridPane);
	}

	@Override
	public void handle(ActionEvent event) {
		Button button = (Button) event.getSource();
		String label = button.getText();

		if (label.matches("[0-9]")) {
			if (operator.isEmpty()) {
				operand1 += label;
			} else {
				operand2 += label;
			}
			displayText.setText(label);
		} else if (label.equals("/") || label.equals("*") || label.equals("-") || label.equals("+")) {
			operator = label;
		} else if (label.equals("=")) {
			int num1 = Integer.parseInt(operand1);
			int num2 = Integer.parseInt(operand2);
			int result = 0;

			switch (operator) {
				case "/":
					if (num2 != 0) {
						result = num1 / num2;
					} else {
						displayText.setText("Error: División entre 0");
						return;
					}
					break;
				case "*":
					result = num1 * num2;
					break;
				case "-":
					result = num1 - num2;
					break;
				case "+":
					result = num1 + num2;
					break;
			}

			displayText.setText(String.valueOf(result));
			operand1 = String.valueOf(result);
			operand2 = "";
			operator = "";
		} else if (label.equals("Clear")) {
			displayText.setText("");
			operand1 = "";
			operand2 = "";
			operator = "";
		}
	}
}