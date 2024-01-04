import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game GUI");

        // Create a button
        Button startButton = new Button("Start Game");

        // Set action on button click
        startButton.setOnAction(e -> {
            // Add game logic or open a new game window
            System.out.println("Game started!");
        });

        // Create a layout and add the button to it
        StackPane layout = new StackPane();
        layout.getChildren().add(startButton);

        // Create a scene and set it in the stage
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }
}
