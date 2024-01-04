import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class tut6 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Stage window = primaryStage;
        window.setTitle("Java painful");

        Button button = new Button("Click me");

        button.setOnAction(e -> {
            boolean result = tut6ConfirmBox.display("Nanu?", "Do you want to quit");
            System.out.println(result);
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 900, 600);
        window.setScene(scene);
        window.show();
    }
}