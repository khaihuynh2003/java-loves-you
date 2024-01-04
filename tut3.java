import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class tut3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Java painful");

        Button startButton = new Button("Hey bae");

        startButton.setOnAction(e -> {
            System.out.println("Hey my hero");
            System.out.println("You are so handsome");
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(startButton);

        Scene scene = new Scene(layout, 900, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
} 