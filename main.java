import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Aesthetic GUI");

        // Create main layout
        VBox root = new VBox(20);
        root.setStyle("-fx-background-color: #f0f0f0; -fx-font-family: 'Arial';");

        // Create title label
        Label titleLabel = new Label("Welcome to Aesthetic GUI");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Create buttons
        Button button1 = createStyledButton("Button 1");
        Button button2 = createStyledButton("Button 2");

        // Add components to the layout
        root.getChildren().addAll(titleLabel, button1, button2);
        root.setPadding(new Insets(50));

        // Create scene
        Scene scene = new Scene(root, 400, 300, Color.WHITE);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    private Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setStyle(
                "-fx-background-color: #4CAF50; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-padding: 10px 20px; " +
                        "-fx-border-radius: 5px; " +
                        "-fx-cursor: hand;"
        );
        return button;
    }
}
