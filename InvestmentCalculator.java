import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class InvestmentCalculator extends Application {
    // create textfield here so other functions have access to them
    private static TextField txtAmount = new TextField();
    private static TextField txtYears = new TextField();
    private static TextField txtRate = new TextField();
    private static TextField txtValue = new TextField();

    @Override
    public void start(Stage primaryStage) {

        // create a pane and set its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // place labels in the pane
        pane.add(new Label("Investment Amount"), 0, 0);
        pane.add(new Label("Years"), 0, 1);
        pane.add(new Label("Annual Interest Rate"), 0, 2);
        pane.add(new Label("Future value"), 0, 3);

        // place text fields in the pane
        pane.add(txtAmount, 1, 0);
        txtAmount.setAlignment(Pos.BASELINE_RIGHT);
        pane.add(txtYears, 1, 1);
        txtYears.setAlignment(Pos.BASELINE_RIGHT);
        pane.add(txtRate, 1, 2);
        txtRate.setAlignment(Pos.BASELINE_RIGHT);
        pane.add(txtValue, 1, 3);
        txtValue.setAlignment(Pos.BASELINE_RIGHT);
        txtValue.setEditable(false);    // text field is not grayed out and can be selected

        // place button in the pane
        Button btn = new Button("Calculate");
        CalculateHandlerClass handler = new CalculateHandlerClass();
        btn.setOnAction(handler);
        pane.add(btn, 1, 4 );
        GridPane.setHalignment(btn, HPos.RIGHT);

        // create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Investment-Value Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // a function calculate and display result
    public static void calculateValue() {
        double amount = Double.parseDouble(txtAmount.getText());
        double rate = Double.parseDouble(txtRate.getText());
        int years = Integer.parseInt(txtYears.getText());

        // result is different from example
        double futureValue = amount * Math.pow((1 + rate/12),(years * 12));

        txtValue.setText(String.format("%.2f", futureValue));
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class CalculateHandlerClass implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        InvestmentCalculator.calculateValue();
    }
}