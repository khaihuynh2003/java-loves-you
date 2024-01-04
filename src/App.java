import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Java painful");

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        Button button = new Button("Exit game");

        button.setOnAction(e -> {
            closeProgram();
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 900, 600);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram()
    {
        boolean answer = tut6ConfirmBox.display("Title", "Sure you want to exit?");
        if(answer) {
            window.close();
        }
    }
}