import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class DisplayCards extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(15));
        String path;

        // generate three numbers between 1-54
        Random random = new Random();
        String num1, num2, num3;

        num1 = String.valueOf(random.nextInt(54)+1);
        num2 = String.valueOf(random.nextInt(54)+1);
        num3 = String.valueOf(random.nextInt(54)+1);

        Image card1 = new Image("file:///C:/Users/kaden/Downloads/Cards/"+num1+".png");
        Image card2 = new Image("file:///C:/Users/kaden/Downloads/Cards/"+num2+".png");
        Image card3 = new Image("file:///C:/Users/kaden/Downloads/Cards/"+num3+".png");

        pane.getChildren().addAll(new ImageView(card1), new ImageView(card2), new ImageView(card3));

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise14_03");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
